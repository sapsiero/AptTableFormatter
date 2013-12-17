/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package apttableformatter;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tim
 */
public class AptFormatter {
    
    private static final int MAX_WIDTH = 40;
    
    private String source;
    
    private String target;
    
    private int rowNum;
    
    private int colNum;
    
    private List<List<StringBuilder>> splittedContent;
    
    private int[] columnWidth;
    
    public AptFormatter(String source) {
        this.source = source;
        splittedContent = new ArrayList<>();
    }
    
    public void process() {
        String[] rows = source.split("\n");
        
        boolean tableBegin = false;
        
        for (String row : rows) {
            
            if (!tableBegin && row.startsWith("*")) {
                colNum = row.split("\\+").length;
                splittedContent.add(new ArrayList<StringBuilder>());
                tableBegin = true;
            } else if (row.startsWith("*")) {
                splittedContent.add(new ArrayList<StringBuilder>());
                rowNum++;
            } else if (row.startsWith("|")) {
                List<StringBuilder> currentContent = splittedContent.get(rowNum);
                
                String[] rowcontent = row.split("\\|");
                
                for (int i = 0; i < rowcontent.length; i++) {
                    if (currentContent.size() > i) {
                        if (currentContent.get(i).length() > 0) {
                            currentContent.get(i).append(" ");
                        }
                    } else {
                        currentContent.add(new StringBuilder());
                    }
                    if (rowcontent.length > i+1) {
                        currentContent.get(i).append(rowcontent[i + 1].trim());
                    }
                }
            }
        }
        
        columnWidth = new int[colNum];
        
        for (int i = 0; i < colNum; i++) {
            
            for (List<StringBuilder> currentContent : splittedContent) {
                
                if (currentContent.size() > 0) {
                
                    int length = currentContent.get(i).length();

                    if (length > columnWidth[i]) {
                        columnWidth[i] = Math.min(length, MAX_WIDTH);
                    }
                    
                }
            }
        }
        
        StringBuilder builder = new StringBuilder();
        
        addSeparator(builder);
        
        for (List<StringBuilder> rowContent : splittedContent) {
            if (rowContent.size() > 0) {
                addContent(builder, rowContent);
                addSeparator(builder);
            }
        }
        
        target = builder.toString();
    }
    
    public String getTarget() {
        return target;
    }
    
    private void addSeparator(StringBuilder builder) {
        builder.append("*");
        for (int width : columnWidth) {
            for (int i = 0; i < width; i++) {
                builder.append("-");
            }
            builder.append("+");
        }
        builder.append("\n");
    }
    
    private void addContent(StringBuilder builder, List<StringBuilder> rowContent) {
        
        boolean cont = true;
        
        while (cont) {
            builder.append("|");
            
            boolean foundLongText = false;
            
            for (int i = 0; i < columnWidth.length; i++) {
                int width = columnWidth[i];
                int length = 0;
                StringBuilder column = rowContent.get(i);

                if (column.length() > width) {
                    int lastSpace = getLength(column.substring(0, width));
                    
                    System.out.println(lastSpace);
                    
                    builder.append(column.substring(0, lastSpace));
                    column.delete(0, lastSpace + 1);
                    
                    foundLongText = true;
                    length = lastSpace;
                } else {
                    builder.append(column.toString());
                    length = column.length();
                    column.delete(0, column.length());
                }

                for (int j = 0; j < Math.max(0, width - length); j++) {
                    builder.append(" ");
                }
                builder.append("|");

            }
            builder.append("\n");
            
            cont = foundLongText;
        }
    }
    
    private int getLength(String string) {
        for (int i = string.length() - 1; i >= 0; i--) {
            if (string.substring(i, i+1).equals(" ")) {
                return i;
            }
        }
        return string.length();
    }
}
