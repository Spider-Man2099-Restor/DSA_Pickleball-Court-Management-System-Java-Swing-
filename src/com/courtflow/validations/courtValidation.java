
package com.courtflow.validations;

import com.courtflow.io.FileUtil;
import java.io.IOException;
import java.util.List;

public class courtValidation {
    
    public boolean duplicateName(String courtNumber) throws IOException {
        List<String> lines = FileUtil.readLines("Courts.txt");

        for (String line : lines) {
            String[] parts = line.split("\\|"); // Change "," to whatever separator you use

            if (parts.length <= 3 && courtNumber.trim().equalsIgnoreCase(parts[0].trim())) {
                return true; // Duplicate found!
            }
        }

        return false; // No duplicate found
    }
    
    public boolean duplicateId(String id) throws IOException {
        List<String> lines = FileUtil.readLines("Players.txt");

        for (String line : lines) {
            String[] parts = line.split("\\|"); // Change "," to whatever separator you use

            if (parts.length <= 4 && id.trim().equalsIgnoreCase(parts[0].trim())) {
                return true; // Duplicate found!
            }
        }

        return false; // No duplicate found
    }
}
