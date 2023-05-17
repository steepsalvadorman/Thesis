
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;

public class DisplayPanel extends JPanel implements ActionListener //create display panel
{

    private static final long serialVersionUID = 1L;
    private final int displayWidth = 557; //sudoku display its 557 pixels wide
    private int DisplayHeight = 580; //sudoku display its 580 pixels high
    private int ButtonsWidth = 200; //button panel its 200 pixels wide
    private final Color WS = new Color(0xf5, 0xf5, 0xf5);  //White Smoke 
    private final Color MB = new Color(0x00, 0x00, 0xcd);  //Medium blue
    private final Color P = new Color(0x80, 0, 0x80);  //purple blank number 

    public DisplayPanel() //construct the sudoku display panel
    {
        addMouseListener(new MouseAdapter() //we listen for mouse clicks on this panel
        {
            @Override
            public void mousePressed(MouseEvent e) {
                selectNumber(e.getX(), e.getY());   //the called method on mouse click         	
            }//end of mouse select
        });//end of mouse listener
        this.setLayout(new BorderLayout());

        JPanel pb = new JPanel();   //create the button panel
        pb.setPreferredSize(new Dimension(ButtonsWidth, DisplayHeight));
        pb.setBackground(WS);

        FlowLayout FL = new FlowLayout();
        FL.setVgap(55);
        FL.setHgap(100);  //set the flow layout to give  symmetric display
        pb.setLayout(FL);
        SButton SS = new SButton(" Solved Sudoku ", "SS");
        SS.addActionListener(this);
        pb.add(SS);
        SButton GBS = new SButton(" Undo ", "GBS");
        GBS.addActionListener(this);
        pb.add(GBS);
        SButton ES = new SButton(" Easy ", "ES");
        ES.addActionListener(this);
        pb.add(ES);
        SButton MS = new SButton(" Medium ", "MS");
        MS.addActionListener(this);
        pb.add(MS);
        SButton HS = new SButton(" Hard ", "HS");
        HS.addActionListener(this);
        pb.add(HS);
        SButton CS = new SButton(" Custom Sudoku", "CS");
        CS.addActionListener(this);
        pb.add(CS);

        this.add(pb, BorderLayout.WEST); //add the push button panel to the display panel       
    }//end of constructor

    private void selectNumber(int x, int y) {
        final int[] numberPosition = {3, 63, 124, 187, 248, 309, 372, 433, 494};
        final byte pSNumberY = 19;
        final int buttonsWidth = ButtonsWidth;
        final int displayHeight = DisplayHeight;
        final int displayWidth = this.displayWidth;

        if (x < buttonsWidth + numberPosition[0]) {
            return;
        }
        x -= buttonsWidth - numberPosition[0];

        byte xPosition = 0;
        for (byte count = 0; count < 9; count++) {
            if (x > numberPosition[count]) {
                xPosition = count;
            }
        }

        byte yPosition = 0;
        for (byte count = 0; count < 9; count++) {
            if (y > numberPosition[count]) {
                yPosition = count;
            }
        }
        byte position = (byte) (xPosition + yPosition * 9);

        byte xNumber = 0;
        x -= numberPosition[xPosition];
        for (byte count = 0; count < 3; count++) {
            if (x > pSNumberY * count) {
                xNumber = count;
            }
        }

        byte yNumber = 0;
        y -= numberPosition[yPosition];
        for (byte count = 0; count < 3; count++) {
            if (y > pSNumberY * count) {
                yNumber = count;
            }
        }
        byte number = (byte) (xNumber + yNumber * 3);

        MySudoku.step = Smethods.select(MySudoku.sudoku, number, position, MySudoku.step);
        repaint(buttonsWidth, 0, displayWidth, displayHeight);
    }

    @Override
    public Dimension getPreferredSize() //set the preferred size of display panel
    {
        return new Dimension(displayWidth + ButtonsWidth, DisplayHeight);
    }//end of get dimension of DisplayPanel(button panel + sudoku display)

    @Override
    protected void paintComponent(Graphics g) //called whenever the display panel needs painting
    {
        final byte Foot = 24; //the height of the foot for sudoku
        final byte NumberX = 11;  //the X offset for the string selected display
        final byte NumberY = 54;  //the Y offset for the string selected display
        final byte blanksize = 59;  //the size of the can't select square
        final byte pNumberX = 4;  //the X offset for the string pencil display
        final byte pNumberY = 18;  //the Y offset for the string pencil display
        final byte pSNumberX = 20;  //the X spacing for the string pencil display
        final byte pSNumberY = 19;  //the Y spacing for the string pencil display
        final int FootMessageX = 96;  //the X offset for foot message
        final int FootMessageY = 574;  //the X offset for foot message
        final int FootNumberX = 211;  //X offset for step number
        final int FootNumberY = 574;  //Y offset for step number
        //Grid lines for the display
        int BigLines[] = {0, 184, 369, 554, 577};  //block of 3 x 3 numbers  3 pixels wide
        int SmallLines[] = {62, 123, 247, 308, 432, 493};  //each number   1 pixel wide
        int NumberPosition[] = {3, 63, 124, 187, 248, 309, 372, 433, 494}; //number display
        Font fontSelected = new Font("SansSerif", Font.ROMAN_BASELINE, 70);  //selected number
        Font fontFoot = new Font("SansSerif", Font.ROMAN_BASELINE, 20);  //the foot text
        Font fontPencil = new Font("SansSerif", Font.ROMAN_BASELINE, 20);  //pencil lines

        super.paintComponent(g); //paint the component's JPanel     
        g.setColor(MB);
        g.setFont(fontPencil);
        //g.drawString(String.valueOf(numberops.number),squareX,squareY); //the sudoku step number

        //horizontal lines
        byte count;  //counter for position 0 to 80
        for (count = 0; count < 5; count++) {
            g.fillRect(0, BigLines[count], displayWidth + ButtonsWidth, 3);
        }
        for (count = 0; count < 6; count++) {
            g.drawLine(0, SmallLines[count], displayWidth + ButtonsWidth, SmallLines[count]);
        }
        //vertical lines
        g.fillRect(BigLines[0] + ButtonsWidth, 0, 3, DisplayHeight);
        g.fillRect(BigLines[1] + ButtonsWidth, 0, 3, DisplayHeight - Foot);
        g.fillRect(BigLines[2] + ButtonsWidth, 0, 3, DisplayHeight - Foot);
        g.fillRect(BigLines[3] + ButtonsWidth, 0, 3, DisplayHeight);
        for (count = 0; count < 6; count++) {
            g.drawLine(SmallLines[count] + ButtonsWidth, 0, SmallLines[count] + ButtonsWidth, DisplayHeight - Foot);
        }
        //foot text
        g.setFont(fontFoot);
        g.drawString(" Step No: ", FootMessageX + ButtonsWidth, FootMessageY);
        g.drawString(String.valueOf(MySudoku.step), FootNumberX + ButtonsWidth, FootNumberY);
        byte numbercount;
        for (numbercount = 0; numbercount < 81; numbercount++) {
            g.setColor(MB);  //reset color to MB
            byte zeros = 0; //count the number of zeros in the number(9 pencils numbers)
            byte outercount;  //outside counter
            for (outercount = 0; outercount < 3; outercount++) {
                for (count = 0; count < 3; count++) {
                    byte pencilnumber = MySudoku.sudoku[count + outercount * 3 + numbercount * 9][MySudoku.step];
                    if (pencilnumber > 0) //do we display this letter
                    {
                        if (pencilnumber < 10) {
                            g.setFont(fontPencil);
                            g.drawString(String.valueOf(pencilnumber), NumberPosition[numbercount % 9] + (count * pSNumberX) + pNumberX + ButtonsWidth, NumberPosition[numbercount / 9] + outercount * pSNumberY + pNumberY);
                        } //draw the pencil number
                        else {
                            g.setFont(fontSelected);
                            g.drawString(String.valueOf(pencilnumber - 10), NumberPosition[numbercount % 9] + ButtonsWidth + NumberX, NumberPosition[numbercount / 9] + NumberY);
                        } //draw the selected number
                    }//end of we display this number
                    else {
                        zeros += 1; //we have a zero don't display and count it
                    }
                }//end of draw 3 pencil count
            }//end of draw  9 pencils outercount
            if (zeros == 9) {
                g.setColor(P);  //show purple square can't select any number
                g.fillRect(NumberPosition[numbercount % 9] + ButtonsWidth, NumberPosition[numbercount / 9], blanksize, blanksize);
            }
        }
    }

    @Override
public void actionPerformed(ActionEvent e) {
    String actionCommand = e.getActionCommand();
    
        switch (actionCommand) {
            case "CS":
                MySudoku.step = 0;
                break;
            case "HS":
                Smethods.trysudoku(MySudoku.sudoku, (byte) 0);
                MySudoku.step = 25;
                break;
            case "MS":
                Smethods.trysudoku(MySudoku.sudoku, (byte) 0);
                MySudoku.step = 35;
                break;
            case "ES":
                Smethods.trysudoku(MySudoku.sudoku, (byte) 0);
                MySudoku.step = 45;
                break;
            case "SS":
                Smethods.trysudoku(MySudoku.sudoku, MySudoku.step);
                break;
            case "GBS":
                if (MySudoku.step > 0) {
                    MySudoku.step -= 1;
                }       break;
            default:
                break;
        }

    repaint(ButtonsWidth, 0, displayWidth, DisplayHeight);
}

}
