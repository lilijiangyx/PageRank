import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jianl018 on 2018-12-13.
 */
public class Helper {
  public static void main(String[] args) throws IOException {

    BufferedReader pr = new BufferedReader(new FileReader("/Users/jianl018/Desktop/BigDataProjects/PageRank/pagerank30/pr30.txt"));
    BufferedReader transition = new BufferedReader(new FileReader("/Users/jianl018/Desktop/BigDataProjects/PageRank/transition/transition.txt"));
    FileWriter fileWriter = new FileWriter("/Users/jianl018/Desktop/BigDataProjects/PageRank/result/result.csv");

    Map<String, String> page_pr = new HashMap<>();

    String line = pr.readLine();
    while(line != null){
      page_pr.put(line.split("\t")[0], line.split("\t")[1]);
      line = pr.readLine();
    }
    pr.close();


    line = transition.readLine();
    fileWriter.write("source,target,value\n");
    while (line != null) {

      String[] from_tos = line.split("\t");
      String[] tos = from_tos[1].split(",");
      for (String to: tos) {
        String value = page_pr.get(to);
        fileWriter.write(from_tos[0] + "," + to + "," + value + "\n");
      }
      line = transition.readLine();
    }

    transition.close();
    fileWriter.close();
  }
}
