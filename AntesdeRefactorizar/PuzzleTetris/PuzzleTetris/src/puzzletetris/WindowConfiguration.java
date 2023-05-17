package puzzletetris;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class WindowConfiguration extends JDialog implements ActionListener
{
    JCheckBox musicchk = new JCheckBox("Music");
    JCheckBox sfxchk = new JCheckBox("Sfx");
    JComboBox lstdifficult = new JComboBox(new String[] {"1", "2", "3"});
    JButton Save = new JButton("Save");
    JButton Cancel = new JButton("Cancel");
    GameConfiguration options = new GameConfiguration();
    
    public WindowConfiguration()
    {
        Save.addActionListener(this);
        Cancel.addActionListener(this);
        setLayout(new GridLayout(3, 2));
        add(musicchk);
        add(sfxchk);
        add(new JLabel("Difficult"));
        add(lstdifficult);
        add(Save);
        add(Cancel);
        setBounds(100,100,200,100);
    }
    
    public void setVisible(int x, int y, boolean visible)
    {
        options.loadOptions();
        musicchk.setSelected(options.confAtributes.Music);
        sfxchk.setSelected(options.confAtributes.sfx);
        lstdifficult.setSelectedIndex(options.confAtributes.difficult-1);      
        setLocation(x,y);
        setVisible(visible);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource() == Save)
        {
            options.confAtributes.Music = musicchk.isSelected();
            options.confAtributes.sfx = sfxchk.isSelected();
            options.confAtributes.difficult = Integer.parseInt(lstdifficult.getSelectedItem().toString());
            new GameConfiguration().createConfFile(options.confAtributes);
            this.setVisible(false);
        }
        if(e.getSource() == Cancel)
        {
            this.setVisible(false);
        }
    }
}