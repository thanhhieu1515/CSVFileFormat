
package common;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.CSV;


public class Algorithm {
    Library l = new Library();
    public void importFile(ArrayList<CSV> arr) {
        String file = l.getString("Enter path: ");
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = br.readLine();
            while (line != null) {
                String[] split = line.split(",");
                CSV newCSV = new CSV(Integer.parseInt(split[0].trim()), split[1].trim(), 
                        split[2].trim(), split[3].trim(), split[4].trim());
                arr.add(newCSV);
                line = br.readLine();
            }
            System.err.println("Importing successfully");
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("Not found");
            e.getMessage();
        } catch (IOException e) {
            e.getMessage();
        }
        
    }
    public void formatName(ArrayList<CSV> arr) {
        for (int i = 0; i < arr.size(); i++) {
            String name = arr.get(i).getName().toLowerCase().replaceAll("\\s+", ",");
            String[] split = name.split(",");
            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < split.length; j++)
                sb.append(Character.toUpperCase(split[j].charAt(0)))
                            .append(split[j].substring(1)).append(" ");
            arr.get(i).setName(sb.toString().trim());
        }
        System.err.println("Format Name: done");
    }
    public void formatAddress(ArrayList<CSV> arr) {
        for (int i = 0; i < arr.size(); i++) {
            String address = arr.get(i).getAddress().toLowerCase().replaceAll("\\s+", ",");
            String[] split = address.split(",");
            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < split.length; j++) 
                sb.append(Character.toUpperCase(split[j].charAt(0)))
                            .append(split[j].substring(1)).append(" ");
            arr.get(i).setAddress(sb.toString().trim());
        }
        System.err.println("Format Address: done");
    }
    public void exportFile(ArrayList<CSV> arr) {
//        FileWriter fileWriter = null;
        String file = l.getString("Enter path: " );
        BufferedWriter bw;
        try {
            bw = new BufferedWriter(new FileWriter(file));
            for (CSV csv : arr) {
            String line = String.valueOf(csv.getId()) + ", " + csv.getName() + ", "
                    + csv.getEmail() + ", " + csv.getPhone() + ", " + csv.getAddress();
            bw.write(line);
            bw.newLine();
        }
        } catch (IOException ex) {
            ex.getMessage();
        }
        
//        try {
//            fileWriter = new FileWriter(file);
//            for (CSV csv : arr) {
//                fileWriter.append(String.valueOf(csv.getId()));
//                fileWriter.append(", ");
//                fileWriter.append(String.valueOf(csv.getName()));
//                fileWriter.append(", ");
//                fileWriter.append(String.valueOf(csv.getEmail()));
//                fileWriter.append(", ");
//                fileWriter.append(String.valueOf(csv.getPhone()));
//                fileWriter.append(", ");
//                fileWriter.append(String.valueOf(csv.getAddress()));
//                fileWriter.append(".\n");
//            }
//            System.err.println("Export done");
//        } catch (IOException ex) {
//            ex.getMessage();
//        }
    }
    
}
