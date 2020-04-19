package challenges.hackerrank.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

enum Color {
    RED, GREEN
}

abstract class Tree {

    private int value;
    private Color color;
    private int depth;

    public Tree(int value, Color color, int depth) {
        this.value = value;
        this.color = color;
        this.depth = depth;
    }

    public int getValue() {
        return value;
    }

    public Color getColor() {
        return color;
    }

    public int getDepth() {
        return depth;
    }

    public abstract void accept(TreeVis visitor);
}

class TreeNode extends Tree {

    private ArrayList<Tree> children = new ArrayList<>();

    public TreeNode(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitNode(this);

        for (Tree child : children) {
            child.accept(visitor);
        }
    }

    public void addChild(Tree child) {
        children.add(child);
    }
}

class TreeLeaf extends Tree {

    public TreeLeaf(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitLeaf(this);
    }
}

abstract class TreeVis
{
    public abstract int getResult();
    public abstract void visitNode(TreeNode node);
    public abstract void visitLeaf(TreeLeaf leaf);

}

class SumInLeavesVisitor extends TreeVis {
	int sum = 0;
    public int getResult() {
        return sum;
    }

    public void visitNode(TreeNode node) {
      	//implement this
    }

    public void visitLeaf(TreeLeaf leaf) {
      	sum += leaf.getValue();
    }
}

class ProductOfRedNodesVisitor extends TreeVis {
	int product = 1;
	
    public int getResult() {
        return product;
    }

    public void visitNode(TreeNode node) {
    	if(node.getColor() == Color.RED) {
    		product = (product * node.getValue()) % 1000000007;
    	}
    }

    public void visitLeaf(TreeLeaf leaf) {
    	if(leaf.getColor() == Color.RED) {
    		product = (product * leaf.getValue()) % 1000000007;
    	}
    }
}

class FancyVisitor extends TreeVis {
    int nonLeafSum = 0;
    int leafSum = 0;
	
	public int getResult() {
        return Math.abs(nonLeafSum - leafSum);
    }

    public void visitNode(TreeNode node) {
    	if(node.getDepth() % 2 == 0) {
    		nonLeafSum += node.getValue();
    	}
    }

    public void visitLeaf(TreeLeaf leaf) {
    	if(leaf.getColor() == Color.GREEN) {
    		leafSum += leaf.getValue();
    	}
    }
}

/**
 * https://www.hackerrank.com/challenges/java-vistor-pattern/problem
 */
public class JavaVisitorPattern {
	
	private static List<Tree> nodes;
	private static List<Integer> nodeValues;
	private static List<Color> colorValues;
	private static Map<Integer, Integer> edges;
  
    public static Tree solve() {
        try(Scanner s = new Scanner(System.in)) {
        	//Taking number of Nodes
        	int n = s.nextInt();
        	s.nextLine();
        	nodes = new ArrayList<>(n);
        	nodeValues = new ArrayList<>(n);
        	colorValues = new ArrayList<>(n);
        	
        	//Taking node values
        	String[] values = s.nextLine().split("\\s");
        	for(int i = 0; i < values.length; i++) {
        		nodeValues.add(Integer.parseInt(values[i]));
        	}
        	
        	//Taking node colors
        	String[] colors = s.nextLine().split("\\s");
        	for(int i = 0; i < colors.length; i++) {
        		colorValues.add((Integer.parseInt(colors[i]) == 0) ? Color.RED : Color.GREEN);
        	}
        	
        	//Taking Edges
        	edges = new HashMap<>(n - 1);
        	for(int j = 0; j < n - 1; j++) {
        		int parent = s.nextInt() - 1;
        		int child = s.nextInt() - 1;
        		if(edges.containsKey(child)) {
        			edges.put(parent, child);
        		} else {
        			edges.put(child, parent);
        		}
        	}
        	
        	//Adding TreeNodes
        	//Adding First TreeNode
        	nodes.add(new TreeNode(nodeValues.get(0), colorValues.get(0), 0));
        	//Initializing list with nulls
        	for(int i = 1; i < n; i++) {
        		nodes.add(null);
        	}
        	for(int i = 1; i < n; i++) {
        		if(nodes.get(i) == null) {
        			createNode(i);
        		}
        	}
        	
        	//Adding Child nodes
        	for(int k : edges.keySet()) {
        		((TreeNode) nodes.get(edges.get(k))).addChild(nodes.get(k));
        	}
        	
        	return nodes.get(0);
        }
    }
    
    private static void createNode(int index) {
    	int value = nodeValues.get(index);
		Color color = colorValues.get(index);
		int depth = 0;
		int parentIndex = edges.get(index);
		if(nodes.get(parentIndex) == null) {
			createNode(parentIndex);
			depth = nodes.get(parentIndex).getDepth() + 1;
		} else {
			depth = nodes.get(parentIndex).getDepth() + 1;
		}
    	
    	//If the current node has child i.e. if it is a parent node
		//Then it should be a tree node. else it should be a leaf node
		if(edges.containsValue(index)) {
			TreeNode node = new TreeNode(value, color, depth);
			nodes.set(index, node);
		} else {
			nodes.set(index, new TreeLeaf(value, color, depth));
		}
    }
    
    public static void main(String[] args) {
      	Tree root = solve();
		SumInLeavesVisitor vis1 = new SumInLeavesVisitor();
      	ProductOfRedNodesVisitor vis2 = new ProductOfRedNodesVisitor();
      	FancyVisitor vis3 = new FancyVisitor();

      	root.accept(vis1);
      	root.accept(vis2);
      	root.accept(vis3);

      	int res1 = vis1.getResult();
      	int res2 = vis2.getResult();
      	int res3 = vis3.getResult();

      	System.out.println(res1);
     	System.out.println(res2);
    	System.out.println(res3);
	}
}