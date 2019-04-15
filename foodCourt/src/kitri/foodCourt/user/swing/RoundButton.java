package kitri.foodCourt.user.swing;

import java.awt.*;
import java.awt.event.MouseListener;
import javax.swing.*;

public class RoundButton extends JButton implements MouseListener{
	
	//라운드정도와 선의 두께
	public int arc;
	public int thickness;
	public Color enterColor;
	public Color exitColor;

	public RoundButton() {
		super();
		defaultSetting();
	}

	public RoundButton(Action a) {
		super(a);
		defaultSetting();
	}

	public RoundButton(Icon icon) {
		super(icon);
		defaultSetting();
	}

	public RoundButton(String text, Icon icon) {
		super(text, icon);
		defaultSetting();
	}

	public RoundButton(String text) {
		super(text);
		defaultSetting();
	}
	
	public RoundButton(int thickness, int arc) {
		this.arc = arc;
		this.thickness = thickness;
		defaultSetting();
	}
	
	public void defaultSetting() {
		setBackground(Color.WHITE);
		setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.enterColor = SwingFactory.hexToRgb("#FFF8DC");
		
		//생성한 객체에서 바로 마우스이벤트를 등록시켜버림. 이 객체로 생성하면 다 같은 액션이 일어남
		//클릭부는 구현하지 않고 actionListener 를 이용한다.
		addMouseListener(this);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		//배경색 칠하기 button의 경우 이미지가 사용될 수도 있기에 따로 처리.
		if(getIcon() == null) {
			g.setColor(getBackground());
			g.fillRoundRect(thickness/2, thickness/2, getWidth()-thickness, getHeight()-thickness, arc, arc);
		}else {
			g.setColor(getBackground());
			g.fillRoundRect(thickness/2, thickness/2, getWidth()-thickness, getHeight()-thickness, arc, arc);
			super.paintComponent(g);
		}
		
		//버튼안에 글자 구현부.. 위치는각자 입맛에 맞게 조절할것
		if(!getText().isEmpty()) {
			g.setColor(getForeground());
			g.setFont(getFont());
			int length = getText().length();
			int size = getFont().getSize();
			if(length % 2 == 1) {
				length += 1;
			}
			if(size % 2 == 1) {
				size += 1;
			}
			g.drawString(getText(), getWidth()/2-(length*size)/2, getHeight()/2+getFont().getSize()/2);
		}
	}

	@Override
	public void mouseClicked(java.awt.event.MouseEvent e) {
	}

	@Override
	public void mousePressed(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(java.awt.event.MouseEvent e) {
		RoundButton button = (RoundButton)e.getComponent();
		if(enterColor != null) {
			button.setBackground(enterColor);
		}else {
			button.setBackground(SystemColor.inactiveCaptionBorder);
		}
		
	}

	@Override
	public void mouseExited(java.awt.event.MouseEvent e) {
		RoundButton button = (RoundButton)e.getComponent();
		if(exitColor != null) {
			button.setBackground(exitColor);
		}else {
			button.setBackground(Color.WHITE);
		}
	}

	
}
