/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gameoflife;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author Mateusz
 */
public class FileService {
    private static byte[][] toByteArray(boolean[][] toConvert)
    {
        byte[][] toReturn = new byte[toConvert.length][toConvert[0].length];
            for (int row = 0; row < toReturn.length; row++) {
                for (int cell = 0; cell < toReturn[0].length; cell++) {
                    toReturn[row][cell] = (byte) (toConvert[row][cell]? 0:1);
            }
        }

        return toReturn; 
    }
    public static boolean writeToMyFile(StructureGoL toSave, File placeToSave)
    {
        
        boolean[][] tmpToSave = toSave.getBoard();
        try {
            FileUtils.writeStringToFile(placeToSave, "");
        } catch (IOException ex) {
            return false;
        }
        for(int line = 0; line < tmpToSave.length; line++){
            try {
                FileUtils.writeByteArrayToFile(placeToSave, toByteArray(toSave.getBoard())[line], true);
                FileUtils.writeStringToFile(placeToSave, "\n", true);
            } catch (IOException ex) { 
                return false;
            }

        }
        
        return true;
    }
    public static boolean[][] loadFromFile(File placeToLoad) throws IOException
    {
        List<String> lines = FileUtils.readLines(placeToLoad);
        boolean[][] result = new boolean[lines.size()][];        
        int counter = 0;
        for(String line: lines)
        {
            result[counter] = new boolean[line.length()];
            for (int i=0, len=line.length(); i<len; i++) {
                if(line.charAt(i) == (char)0 )
                {
                    result[counter][i] = true;
                }else{result[counter][i] = false;}
                
            }
            counter++;
        }
        
        return result;
    }
}
