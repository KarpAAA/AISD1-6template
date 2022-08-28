package Program;



import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class ScreenClass {
    private   JLabel labelArray;
    private static  ScreenClass screenClass;
    private static int count;
    public JLabel getTextField(){
        return this.labelArray;
    }
    private ScreenClass(ArrayList<Integer> arrayList){

        JFrame frame;
        JTextField textToAdd;
        JButton  buttonAddElement;
        JButton  buttonDeleteElement;
        JButton  buttonSortAscending;
        JButton  buttonSortDescending;

        labelArray = new JLabel("EMPTY!!!");
        labelArray.setHorizontalAlignment(JLabel.CENTER);
        labelArray.setPreferredSize(new Dimension(460,30));
        labelArray.setFont(new Font(null,Font.BOLD,20));

        textToAdd = new JTextField();
        textToAdd.setPreferredSize(new Dimension(80,30));
        textToAdd.setFont(new Font(null,Font.BOLD,20));
        textToAdd.setHorizontalAlignment(SwingConstants.CENTER);
        buttonAddElement = new JButton("Add Element");
        buttonAddElement.addActionListener(e->{
            if(textToAdd.getText()!=null && !(textToAdd.getText().isEmpty())){
                arrayList.add(Integer.valueOf(textToAdd.getText()));
                labelArray.setText(arrayList.toString());
            }
        });
        buttonAddElement.setPreferredSize(new Dimension(150,30));

        buttonDeleteElement = new JButton("Delete ALL");
        buttonDeleteElement.setPreferredSize(new Dimension(150,30));
        buttonDeleteElement.addActionListener(e->{
            arrayList.clear();
            labelArray.setText(arrayList.toString());
        });

        JPanel panelEditingArray = new JPanel();
        panelEditingArray.setLayout(new FlowLayout());
        panelEditingArray.setSize(500,150);
        panelEditingArray.setBorder(BorderFactory.createEmptyBorder(25,10,25,20));
        panelEditingArray.setBounds(0,0,500,150);
        panelEditingArray.add(labelArray);
        panelEditingArray.add(textToAdd);
        panelEditingArray.add(buttonAddElement);
        panelEditingArray.add(buttonDeleteElement);





        buttonSortAscending = new JButton("Sort Ascending");
        buttonSortAscending.setSize(new Dimension(200,150));
        buttonSortAscending.addActionListener(e -> {

            Task4 task = new Task4();
            task.variantTask();
            try {
                task.sorting(arrayList, SortingClass.SortingFacilities.ASCENDING, SortingClass.PrintFile.YES);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            task.timeMeasuring();
            labelArray.setText(arrayList.toString());

        });

        buttonSortDescending = new JButton("Sort Descending");
        buttonSortDescending.setSize(new Dimension(200,150));
        buttonSortDescending.addActionListener(e -> {

            try {
                SortingClass.sortBubble(arrayList,SortingClass.SortingFacilities.DESCENDING, SortingClass.PrintFile.NO);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            labelArray.setText(arrayList.toString());
        });

        JPanel sortPanel = new JPanel();
        sortPanel.setLayout(new FlowLayout());
        sortPanel.setSize(500,150);
        sortPanel.setBorder(BorderFactory.createEmptyBorder(0,10,25,20));
        sortPanel.setBounds(0,150,500,150);
        sortPanel.add(buttonSortAscending);
        sortPanel.add(buttonSortDescending);


        frame = new JFrame("SortingBuble");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(new Dimension(500,300));
        frame.add(panelEditingArray);
        frame.add(sortPanel);

        frame.setVisible(true);
    }
    public static ScreenClass getScreenInstance(ArrayList<Integer> arrayList){
        if(screenClass==null){
            screenClass = new ScreenClass(arrayList);
        }
        return screenClass;
    }

}
