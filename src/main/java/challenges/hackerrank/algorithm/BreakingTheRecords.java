package challenges.hackerrank.algorithm;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * https://www.hackerrank.com/challenges/breaking-best-and-worst-records/problem?h_r=next-challenge&h_v=zen
IP:
10
3 4 21 36 10 28 35 5 24 42

OP:
4 0
 */
public class BreakingTheRecords {

	public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> scores = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.breakingRecords(scores);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining(" "))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}

class Result {

    /*
     * Complete the 'breakingRecords' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY scores as parameter.
     */

    public static List<Integer> breakingRecords(List<Integer> scores) {
    	int highestCount = -1;
    	int lowestCount = -1;
    	int highestScore = Integer.MIN_VALUE;
    	int lowestScore = Integer.MAX_VALUE;
    	
    	for(int score: scores) {
    		if(score > highestScore) {
    			highestScore = score;
    			highestCount++;
    			
    		}
    		
    		if(score < lowestScore) {
    			lowestScore = score;
    			lowestCount++;
    		}
    	}
    	
    	return Arrays.asList(highestCount == -1 ? 0 : highestCount, lowestCount == -1 ? 0 : lowestCount);
    }

}