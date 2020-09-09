package challenges.hackerrank.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * https://www.hackerrank.com/challenges/java-vistor-pattern/problem
 */
public class JavaVisitorPattern2 {

	private static List<Tree> nodes;
    private static List<Integer> nodeValues;
    private static List<Color> colorValues;
    private static Map<Integer, Integer> edges;
    private static Map<Integer, Set<Integer>> pcRelation = new HashMap<>();
  
    public static Tree solve() {
        try(Scanner s = new Scanner(System.in)) {
            //Taking number of Nodes
            int n = s.nextInt();
            s.nextLine();
            nodes = new ArrayList<>(n);
            nodeValues = new ArrayList<>(n);
            colorValues = new ArrayList<>(n);
            edges = new HashMap<>(n - 1);
            
            //Taking node values and colors
            String[] values = s.nextLine().split("\\s");
            String[] colors = s.nextLine().split("\\s");
            int e = n - 1;
            for(int i = 0; i < n; i++) {
                nodeValues.add(Integer.parseInt(values[i]));
                colorValues.add((Integer.parseInt(colors[i]) == 0) ? Color.RED : Color.GREEN);
                nodes.add(null);
                if(i < e) {
                	
                }
            }
            
            //Taking Edges
            
            
            //Adding TreeNodes
            //Adding First TreeNode
            nodes.set(0, new TreeNode(nodeValues.get(0), colorValues.get(0), 0));
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
        int parentIndex = 0;
        try {
        	parentIndex = edges.get(index);
        } catch(Exception e) {
        	System.out.println(index);
        }
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