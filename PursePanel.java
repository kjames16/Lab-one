import javax.swing.*;
import java.awt.*;

public class PursePanel extends JPanel {
    private Purse purse;

    private Denomination[] types = new Denomination[] {new Denomination("Hundred-Dollar",100,"bill","Hundred-Dollar.jpeg"),new Denomination("Fifty-Dollar",50,"bill","Fifty-Dollar.jpeg"),
            new Denomination("Twenty-Dollar",20,"bill","Twenty-Dollar.jpeg"),new Denomination("Ten-Dollar",10,"bill","Ten-Dollar.jpeg"),
            new Denomination("Five-Dollar",5,"bill","Five-Dollar.jpeg"), new Denomination("One-Dollar",1,"bill","One-Dollar.jpeg"),
            new Denomination("Quarter",0.25,"coin","Quarter.jpeg"),new Denomination("Dime",0.1,"coin","Dime.jpeg"),
            new Denomination("Nickel",0.05,"coin","Nickel.png"),new Denomination("Penny",0.01,"coin","Penny.jpeg")};

    public void setPurse(Purse p) {
        purse = p;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        this.setPreferredSize(new Dimension(100,100));
        JLabel label = new JLabel();
        label.setIcon(new ImageIcon("Dime.jpeg"));

        this.add(label);

        for(Denomination n: types) {
            if(purse.getCash().containsKey(n)){
                if(purse.getCash().get(n) > 0) {
                    label.setIcon(new ImageIcon(n.img()));
                    int i = 0;
                    do{
                        this.add(label);
                    }while(i < purse.getCash().get(n));

                }

            }
        }



        //this.add(label);
        repaint(10,50,50,20,15);
    }

    }


