import java.awt.*;
import java.awt.event.*;
public class male implements ActionListener {
    Frame f = new Frame();
    Label l1,l2,l3,l4,l5,l6;
    TextField t1,t2,t3;
    Checkbox c1,c2;
    CheckboxGroup c;
    Button b;
	public void actionPerformed(ActionEvent e){
			if(Integer.parseInt(t3.getText())<Integer.parseInt("18")){
				l5.setText("You are not Eligible");
			else
				l5.setText("You are Eligible");
		
	}
    male()
    {
	f.setVisible(true);
        f.setLayout(null);
        f.setTitle("VOTING FORM");
	f.addWindowListener(new WindowL());
        f.setBounds(200,300,700,800);
        l1 = new Label("Name");
        l2 = new Label("ID");
        l3 = new Label("Age");
        l4 = new Label("Gender");
        t1 = new TextField();
        t2 = new TextField();
        t3 = new TextField();
        l5 = new Label("kmwdksadksmdaskmdksadskd askdskdmaksmdsakd");
        c = new CheckboxGroup();
        c1 = new Checkbox("MALE",c,false);
        c2 = new Checkbox("FEMALE",c,false);
        b = new Button("SUBMIT");
        l1.setBounds(30,40,50,20);
        l2.setBounds(30,60,50,20);
        l3.setBounds(30,80,50,20);
        l4.setBounds(30,100,50,20);
        l5.setBounds(60,120,200,20);
        t1.setBounds(100,40,110,20);
        t2.setBounds(100,60,110,20);
        t3.setBounds(100,80,110,20);
        c1.setBounds(80,100,80,20);
        c2.setBounds(160,100,80,20);
        b.setBounds(80,140,50,20);
	b.addActionListener(this);
        f.add(l1);
        f.add(l2);
        f.add(l3);
        f.add(l4);
        f.add(t1);
        f.add(t2);
        f.add(t3);
	f.add(b);
        f.add(c1);
        f.add(c2);
        f.add(l5);
    }
    public static void main(String[] args) {
        new male();
    }
}
class WindowL implements WindowListener{
	public void windowActivated(WindowEvent ev){}
	public void windowDeactivated(WindowEvent ev){}
	public void windowClosed(WindowEvent ev){}
	public void windowIconified(WindowEvent ev){}
	public void windowDeiconified(WindowEvent ev){}
	public void windowOpened(WindowEvent ev){}
	public void windowClosing(WindowEvent ev){
		ev.getWindow().dispose();		
	}
}
