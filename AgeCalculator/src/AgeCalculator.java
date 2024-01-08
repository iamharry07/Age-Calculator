import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.Period;

public class AgeCalculator {

    private void calculateAge(){

        // date of birth

        JFrame frame = new JFrame("Age Calculator");

        // add a label
        JLabel doblb = new JLabel("Date of Birth: ");
        JLabel messagelb = new JLabel();

        // add a TextField
        JTextField dobtf = new JTextField();

        // add a calculate and close button
        JButton calculateBtn = new JButton("Calculate");
        JButton closebtn = new JButton("Close");

        // setting boundaries
        doblb.setBounds(20,30,100,40);
        dobtf.setBounds(110,40,150,25);
        calculateBtn.setBounds(150,150,100,45);
        closebtn.setBounds(275,150,100,45);
        messagelb.setBounds(200,200,300,45);


        frame.add(doblb);
        frame.add(dobtf);
        frame.add(closebtn);
        frame.add(calculateBtn);
        frame.add(messagelb);

        frame.setLayout(null);
        frame.setResizable(false);
        frame.setSize(600,500);
        frame.setVisible(true);

        // to click on close btn

        closebtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        // to click on calculate btn

        calculateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // converting String field into integer field
                String dobString = dobtf.getText().trim();


                // check the validaton that the dob is not empty

                if (dobString.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please enter the Date of Birth", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    try {
                        LocalDate dob = LocalDate.parse(dobString);
                        LocalDate today = LocalDate.now();
                        Period agePeriod= Period.between(dob, today);
                        int ageYears = agePeriod.getYears();
                        int ageMonth = agePeriod.getMonths();
                        int ageDays = agePeriod.getDays();


                        messagelb.setText("You are " + ageYears + " years, "+ageMonth+" Months and "+ageDays+" Days old");
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(frame, "Invalid date format. yyyy-mm-dd ", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }




            }
        });


    }
    public static void main(String[] args) {
        AgeCalculator ageCalculator = new AgeCalculator();
        ageCalculator.calculateAge();
    }
}
