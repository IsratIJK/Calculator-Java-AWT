import java.awt.*;
import java.awt.event.*;

class GUICalculator extends Frame implements ActionListener {

  TextField textFieldInput;
  Panel panel;

  String btnString[] = { "7", "8", "9", "+", "4", "5", "6", "-", "1", "2", "3", "*", "C", "0", "=", "/" };
  Button btn[] = new Button[16];
  int num1 = 0, num2 = 0, result = 0;
  char operator;

  public GUICalculator() {

    Font f = new Font("Helvetica", Font.PLAIN, 20);

    textFieldInput = new TextField(10);
    textFieldInput.setFont(f);

    panel = new Panel();

    add(textFieldInput, "North");
    add(panel, "Center");

    panel.setLayout(new GridLayout(4, 4));

    for (int i = 0; i < 16; i++) {

      btn[i] = new Button(btnString[i]);
      btn[i].setFont(f);
      btn[i].addActionListener(this);
      panel.add(btn[i]);
    }

    addWindowListener(new WindowAdapter() {

      public void windowClosing(WindowEvent we) {
        System.exit(0);
      }
    });
  }

  public void actionPerformed(ActionEvent ae) {

    String str = ae.getActionCommand();

    if (str.equals("+")) {

      operator = '+';
      num1 = Integer.parseInt(textFieldInput.getText());
      textFieldInput.setText("");
    } else if (str.equals("-")) {
      operator = '-';
      num1 = Integer.parseInt(textFieldInput.getText());
      textFieldInput.setText("");
    } else if (str.equals("*")) {
      operator = '*';
      num1 = Integer.parseInt(textFieldInput.getText());
      textFieldInput.setText("");
    } else if (str.equals("/")) {
      operator = '/';
      num1 = Integer.parseInt(textFieldInput.getText());
      textFieldInput.setText("");
    } else if (str.equals("=")) {

      num2 = Integer.parseInt(textFieldInput.getText());

      switch (operator) {

        case '+':
          result = num1 + num2;
          break;
        case '-':
          result = num1 - num2;
          break;
        case '*':
          result = num1 * num2;
          break;
        case '/':
          result = num1 / num2;
          break;
      }
      textFieldInput.setText(result + "");
      result = 0;
    } else if (str.equals("C")) {

      textFieldInput.setText("");
      num1 = num2 = result = 0;
    } else {
      textFieldInput.setText(textFieldInput.getText() + str);
    }
  }

  public static void main(String args[]) {

    GUICalculator m = new GUICalculator();
    m.setTitle("GUI - Calculator");
    m.setSize(300, 350);
    m.setBackground(Color.PINK);
    m.setForeground(Color.BLACK);
    m.setVisible(true);
  }
}