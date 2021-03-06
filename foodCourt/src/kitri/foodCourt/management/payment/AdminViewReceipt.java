package kitri.foodCourt.management.payment;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class AdminViewReceipt extends JPanel {

	DefaultTableModel dtm = new DefaultTableModel();
	JTable table = new JTable(dtm) {
		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
		};
	};

	JPanel panel = new JPanel();
	JPanel paymentMethodPanel = new JPanel();
	JPanel orderNumPanel = new JPanel();
	JPanel orderDatePanel = new JPanel();
	JPanel memberIDPanel = new JPanel();
	JPanel totalPanel = new JPanel();
	
	JLabel orderNumLabel = new JLabel("\uC8FC\uBB38\uBC88\uD638 :");
	JLabel orderNumValueLabel = new JLabel("orderNumber");
	JLabel orderDateLabel = new JLabel("\uC8FC\uBB38\uC77C\uC2DC :");
	JLabel orderDateValueLabel = new JLabel("orderDate");
	JLabel memberIDLabel = new JLabel("\uD68C\uC6D0ID :");
	JLabel memberIDValueLabel = new JLabel("memberID");
	JLabel moneyLabel = new JLabel("\uD604\uAE08");
	JLabel cardLabel = new JLabel("\uCE74\uB4DC");
	JLabel pointLabel = new JLabel("\uD3EC\uC778\uD2B8");
	JLabel moneyValueLabel = new JLabel("money");
	JLabel cardValueLabel = new JLabel("card");
	JLabel pointValueLabel = new JLabel("point");
	JLabel payTotalLabel = new JLabel("\uACB0\uC81C\uAE08\uC561");
	JLabel payTotalValueLabel = new JLabel("money_card_point");
	JLabel getPointLabel = new JLabel("\uD68D\uB4DD\uD3EC\uC778\uD2B8");
	JLabel getPointValueLabel = new JLabel("percentage15");

	JButton confirmBtn = new JButton("\uD655\uC778");

	JScrollPane scrollPane = new JScrollPane(table);
	
	/**
	 * Create the panel.
	 */
	public AdminViewReceipt() {
		setLayout(null);
		
		panel.setLayout(null);
		panel.setBounds(0, 0, 380, 680);
		add(panel);
		
		scrollPane.setBounds(0, 120, 380, 280);
		panel.add(scrollPane);
		table.setRowSelectionAllowed(false);
		
		//table.setPreferredSize(new Dimension(380, 250));
		table.setPreferredScrollableViewportSize(new Dimension(380, 280));
		table.setShowVerticalLines(true);
		table.setAutoCreateRowSorter(false);
		table.setEnabled(false);
		scrollPane.setViewportView(table);
		
		paymentMethodPanel.setLayout(new GridLayout(2, 3, 0, 0));
		paymentMethodPanel.setBorder(null);
		paymentMethodPanel.setBounds(10, 415, 360, 62);
		panel.add(paymentMethodPanel);
		
		moneyLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
		moneyLabel.setHorizontalAlignment(SwingConstants.CENTER);
		paymentMethodPanel.add(moneyLabel);
		
		cardLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
		cardLabel.setHorizontalAlignment(SwingConstants.CENTER);
		paymentMethodPanel.add(cardLabel);
		
		pointLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
		pointLabel.setHorizontalAlignment(SwingConstants.CENTER);
		paymentMethodPanel.add(pointLabel);
		
		moneyValueLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
		moneyValueLabel.setHorizontalAlignment(SwingConstants.CENTER);
		paymentMethodPanel.add(moneyValueLabel);
		
		cardValueLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
		cardValueLabel.setHorizontalAlignment(SwingConstants.CENTER);
		paymentMethodPanel.add(cardValueLabel);
		
		pointValueLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
		pointValueLabel.setHorizontalAlignment(SwingConstants.CENTER);
		paymentMethodPanel.add(pointValueLabel);
		
		orderNumPanel.setBorder(null);
		orderNumPanel.setBounds(0, 23, 162, 31);
		orderNumPanel.setLayout(new GridLayout(1, 2, 0, 0));
		panel.add(orderNumPanel);
		
		orderNumLabel.setHorizontalAlignment(SwingConstants.CENTER);
		orderNumLabel.setBorder(null);
		orderNumPanel.add(orderNumLabel);
		
		orderNumValueLabel.setHorizontalAlignment(SwingConstants.LEFT);
		orderNumValueLabel.setBorder(null);
		orderNumPanel.add(orderNumValueLabel);
		
		orderDatePanel.setLayout(null);
		orderDatePanel.setBorder(null);
		orderDatePanel.setBounds(164, 23, 215, 31);
		panel.add(orderDatePanel);
		
		orderDateLabel.setBounds(0, 0, 86, 31);
		orderDateLabel.setHorizontalAlignment(SwingConstants.CENTER);
		orderDateLabel.setBorder(null);
		orderDatePanel.add(orderDateLabel);
		
		orderDateValueLabel.setBounds(86, 0, 130, 31);
		orderDateValueLabel.setHorizontalAlignment(SwingConstants.LEFT);
		orderDateValueLabel.setBorder(null);
		orderDatePanel.add(orderDateValueLabel);
		
		memberIDPanel.setLayout(new GridLayout(1, 2, 0, 0));
		memberIDPanel.setBorder(null);
		memberIDPanel.setBounds(170, 52, 172, 31);
		panel.add(memberIDPanel);
		
		memberIDLabel.setHorizontalAlignment(SwingConstants.CENTER);
		memberIDLabel.setBorder(null);
		memberIDPanel.add(memberIDLabel);
		
		memberIDValueLabel.setHorizontalAlignment(SwingConstants.LEFT);
		memberIDValueLabel.setBorder(null);
		memberIDPanel.add(memberIDValueLabel);
		
		confirmBtn.setBounds(127, 598, 128, 48);
		panel.add(confirmBtn);
		
		totalPanel.setBorder(null);
		totalPanel.setBounds(10, 498, 360, 62);
		panel.add(totalPanel);
		totalPanel.setLayout(new GridLayout(2, 2, 0, 0));
		
		payTotalLabel.setHorizontalAlignment(SwingConstants.CENTER);
		payTotalLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
		totalPanel.add(payTotalLabel);
		
		payTotalValueLabel.setHorizontalAlignment(SwingConstants.CENTER);
		payTotalValueLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
		totalPanel.add(payTotalValueLabel);
		
		getPointLabel.setHorizontalAlignment(SwingConstants.CENTER);
		getPointLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
		totalPanel.add(getPointLabel);
		
		getPointValueLabel.setHorizontalAlignment(SwingConstants.CENTER);
		getPointValueLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
		totalPanel.add(getPointValueLabel);
	}
}
