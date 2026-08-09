package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Calculator extends JFrame {


    JTextField txtDisplay;


    JButton[] numberButtons = new JButton[10];

    JButton btnAdd;
    JButton btnSub;
    JButton btnMul;
    JButton btnDiv;

    JButton btnEqual;
    JButton btnClear;
    JButton btnDot;
    JButton btnDelete;
    JButton btnPercent;


    double firstNumber;
    double secondNumber;

    String operator;



    public Calculator(){


        initComponents();


    }




    private void initComponents(){


        setTitle("Calculator");

        setSize(350,500);

        setLocationRelativeTo(null);

        setLayout(null);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);




        txtDisplay = new JTextField();


        txtDisplay.setBounds(
                30,
                30,
                270,
                45
        );


        txtDisplay.setFont(
                new Font("Arial",
                Font.BOLD,
                22)
        );


        txtDisplay.setHorizontalAlignment(
                JTextField.RIGHT
        );


        txtDisplay.setEditable(false);


        add(txtDisplay);






        // Create Number Buttons


        for(int i=0;i<10;i++){


            numberButtons[i] =
                    new JButton(
                            String.valueOf(i)
                    );


        }






        btnAdd = new JButton("+");

        btnSub = new JButton("-");

        btnMul = new JButton("*");

        btnDiv = new JButton("/");

        btnEqual = new JButton("=");

        btnClear = new JButton("C");

        btnDot = new JButton(".");

        btnDelete = new JButton("←");

        btnPercent = new JButton("%");







        // Position Buttons


        numberButtons[7].setBounds(30,100,60,40);
        numberButtons[8].setBounds(100,100,60,40);
        numberButtons[9].setBounds(170,100,60,40);
        btnDiv.setBounds(240,100,60,40);



        numberButtons[4].setBounds(30,150,60,40);
        numberButtons[5].setBounds(100,150,60,40);
        numberButtons[6].setBounds(170,150,60,40);
        btnMul.setBounds(240,150,60,40);



        numberButtons[1].setBounds(30,200,60,40);
        numberButtons[2].setBounds(100,200,60,40);
        numberButtons[3].setBounds(170,200,60,40);
        btnSub.setBounds(240,200,60,40);



        numberButtons[0].setBounds(30,250,60,40);
        btnDot.setBounds(100,250,60,40);
        btnEqual.setBounds(170,250,60,40);
        btnAdd.setBounds(240,250,60,40);



        btnClear.setBounds(30,310,80,40);
        btnDelete.setBounds(120,310,80,40);
        btnPercent.setBounds(210,310,90,40);







        // Add Buttons


        for(int i=0;i<10;i++){

            add(numberButtons[i]);

        }


        add(btnAdd);
        add(btnSub);
        add(btnMul);
        add(btnDiv);

        add(btnEqual);
        add(btnClear);
        add(btnDot);
        add(btnDelete);
        add(btnPercent);







        // Number Action


        ActionListener numberListener =
                new ActionListener(){


            public void actionPerformed(ActionEvent e){


                JButton button =
                        (JButton)e.getSource();



                txtDisplay.setText(
                        txtDisplay.getText()
                        + button.getText()
                );


            }

        };




        for(int i=0;i<10;i++){


            numberButtons[i]
                    .addActionListener(numberListener);


        }








        // Decimal


        btnDot.addActionListener(
                new ActionListener(){


            public void actionPerformed(ActionEvent e){


                if(!txtDisplay.getText()
                        .contains(".")){


                    txtDisplay.setText(
                            txtDisplay.getText()
                            + "."
                    );


                }


            }


        });








        // Operators


        btnAdd.addActionListener(
                new ActionListener(){

            public void actionPerformed(ActionEvent e){

                setOperator("+");

            }

        });




        btnSub.addActionListener(
                new ActionListener(){

            public void actionPerformed(ActionEvent e){

                setOperator("-");

            }

        });




        btnMul.addActionListener(
                new ActionListener(){

            public void actionPerformed(ActionEvent e){

                setOperator("*");

            }

        });




        btnDiv.addActionListener(
                new ActionListener(){

            public void actionPerformed(ActionEvent e){

                setOperator("/");

            }

        });









        // Equal


        btnEqual.addActionListener(
                new ActionListener(){


            public void actionPerformed(ActionEvent e){


                try{


                    secondNumber =
                    Double.parseDouble(
                            txtDisplay.getText()
                    );



                    double result = 0;



                    if(operator.equals("+")){

                        result =
                        firstNumber + secondNumber;

                    }



                    else if(operator.equals("-")){

                        result =
                        firstNumber - secondNumber;

                    }



                    else if(operator.equals("*")){

                        result =
                        firstNumber * secondNumber;

                    }



                    else if(operator.equals("/")){


                        if(secondNumber == 0){

                            JOptionPane.showMessageDialog(
                                    null,
                                    "Cannot divide by zero"
                            );

                            return;

                        }


                        result =
                        firstNumber / secondNumber;

                    }



                    txtDisplay.setText(
                            String.valueOf(result)
                    );


                }
                catch(Exception ex){


                    JOptionPane.showMessageDialog(
                            null,
                            "Invalid Input"
                    );


                }


            }


        });








        // Clear


        btnClear.addActionListener(
                new ActionListener(){


            public void actionPerformed(ActionEvent e){


                txtDisplay.setText("");

                firstNumber = 0;

                secondNumber = 0;


            }


        });








        // Delete


        btnDelete.addActionListener(
                new ActionListener(){


            public void actionPerformed(ActionEvent e){


                String text =
                        txtDisplay.getText();



                if(text.length()>0){


                    txtDisplay.setText(
                            text.substring(
                                    0,
                                    text.length()-1
                            )
                    );


                }


            }


        });








        // Percentage


        btnPercent.addActionListener(
                new ActionListener(){


            public void actionPerformed(ActionEvent e){


                double value =
                Double.parseDouble(
                        txtDisplay.getText()
                );


                value = value / 100;



                txtDisplay.setText(
                        String.valueOf(value)
                );


            }


        });



    }








    private void setOperator(String op){



        firstNumber =
        Double.parseDouble(
                txtDisplay.getText()
        );



        operator = op;



        txtDisplay.setText("");



    }







    public static void main(String[] args){


        new Calculator().setVisible(true);


    }


}