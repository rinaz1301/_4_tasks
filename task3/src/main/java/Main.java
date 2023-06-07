import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;

public class Main {
    static void putIn(HashMap map, List<Test> testList) {
        for (int i = 0; i < testList.size(); i++) {
            if (map.containsKey(testList.get(i).id))
                testList.get(i).value = (String) map.get(testList.get(i).id);
            if (testList.get(i).values != null)
                putIn(map, testList.get(i).values);
        }
    }
    public static void main(String[] args) {

        try{
            FileReader fr1 = new FileReader(args[0]);
            FileReader fr2 = new FileReader(args[1]);
            Writer writer = Files.newBufferedWriter(Paths.get("report.json"));
            Gson gs = new GsonBuilder().setPrettyPrinting().create();
            Tests tests = gs.fromJson(fr1, Tests.class);
            Values values = gs.fromJson(fr2, Values.class);

            HashMap<Integer, String> map = new HashMap<>();
            for(int i=0; i<values.values.size(); i++){
                map.put(values.values.get(i).id, values.values.get(i).value);
            }
            putIn(map, tests.tests);
            gs.toJson(tests, writer);
            writer.close();

        }
        catch (Exception ex){
            ex.printStackTrace();
        }

    }
}
