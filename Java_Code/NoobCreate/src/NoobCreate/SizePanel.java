package NoobCreate;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicArrowButton;

public class SizePanel extends JPanel{

	public SizePanel() {
		super();
		setLayout(new FlowLayout(FlowLayout.LEFT, 20, 0));
		add(new SizeTextAndChange());
		add(new FillTheRegionPanel());
		// TODO Auto-generated constructor stub
	}

}


class SizeTextAndChange extends JPanel{
	
	static JPanel SizeChangeButtons = new JPanel();
	static JPanel SizeChange = new JPanel();
	
	static BasicArrowButton TextSizeUp = new BasicArrowButton(BasicArrowButton.NORTH);
	static BasicArrowButton TextSizeDown = new BasicArrowButton(BasicArrowButton.SOUTH);
	
	static JTextField TextSizeField = new JTextField("15");
	
	static JLabel Text = new JLabel("Size");
	
	public SizeTextAndChange() {
		super();
		SizeChangeButtons.setLayout(new GridLayout(2, 1));
		SizeChangeButtons.setPreferredSize(new Dimension(23, 46));
		TextSizeUp.setPreferredSize(new Dimension(30,30));
		SizeChangeButtons.add(TextSizeUp);
		TextSizeDown.setPreferredSize(new Dimension(30,30));
		SizeChangeButtons.add(TextSizeDown);
		
		SizeChange.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
		TextSizeField.setPreferredSize(new Dimension(100, 50));
		TextSizeField.setFont(new Font("TimesNewRoman", Font.BOLD, 30));
		SizeChange.add(TextSizeField);
		SizeChange.add(SizeChangeButtons);
		
		setLayout(new GridLayout(1, 2));
		Text.setFont(new Font("TimesNewRoman", Font.BOLD, 30));
		add(Text);
		add(SizeChange);
		
		TextSizeUp.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ControlCenter.TextSizePlus1();
				TextSizeField.setText(ControlCenter.getTextSize().toString());
				
				
			}
		});
		
		TextSizeDown.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(ControlCenter.getTextSize()>1){
					ControlCenter.TextSizeMinus1();
				TextSizeField.setText(ControlCenter.getTextSize().toString());
			
				}
			}
		});
		
		TextSizeField.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//ControlCenter.TextSize = Integer.valueOf(TextSizeField.getText());
				if(Integer.valueOf(TextSizeField.getText())>0){
					ControlCenter.setTextSize(Integer.valueOf(TextSizeField.getText()));
				}
				
			}
		});
		// TODO Auto-generated constructor stub
	}
	
}


class FillTheRegionPanel extends JPanel{
	static JCheckBox FillTheRegion = new JCheckBox();
	static JLabel Text = new JLabel("Fill The Reigion");
	public FillTheRegionPanel() {
		super();
		setLayout(new FlowLayout(FlowLayout.LEFT, 10, 0));
		
		FillTheRegion.setPreferredSize(new Dimension(30, 30));
		add(FillTheRegion);
		Text.setFont(new Font("TimesNewRoman", Font.BOLD, 20));
		add(Text);
		
		FillTheRegion.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//ControlCenter.FillShape = FillTheRegion.isSelected();
				ControlCenter.setFillShape(FillTheRegion.isSelected());
				
			}
		});
		// TODO Auto-generated constructor stub
	}

}