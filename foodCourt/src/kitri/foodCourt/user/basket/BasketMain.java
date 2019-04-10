package kitri.foodCourt.user.basket;

import java.net.URL;

import javax.swing.*;
import java.awt.*;

import kitri.foodCourt.dto.FoodDto;
import kitri.foodCourt.user.*;
import kitri.foodCourt.user.swing.*;
import javax.swing.border.*;


public class BasketMain extends JFrame{

	private JPanel contentPane;
	private BasketController controller;
	
	public JPanel pBasketMain;
	public Payment payment;
	public JPanel pChangePanel;
	public JPanel pMiddle;
	public CardLayout card;
	public GridBagLayout gbl_pMiddle;
	public JScrollPane scrollPane;
	
	public FButton btnAllCancel;
	public FButton btnPayment;
	
	//��
	public FLabel lblTotalPrice;
	public FLabel lblTotalPoint;
	
	
	//�׽�Ʈ
	public User user = new User("calubang", "�Ⱥ���", 5000);
	
	public void test() {
		FoodDto food1 = new FoodDto("1", "�����", 1, "�ѽ�", 5000, "/kitri/foodCourt/user/basket/image/����1.jpg");
		FoodDto food2 = new FoodDto("2", "������ũ", 2, "���", 8000, "/kitri/foodCourt/user/basket/image/����1.jpg");
		FoodDto food3 = new FoodDto("3", "�����", 3, "�߽�", 7000, "/kitri/foodCourt/user/basket/image/����1.jpg");
		FoodDto food4 = new FoodDto("4", "������Ű«��", 4, "�Ͻ�", 6000, "/kitri/foodCourt/user/basket/image/����1.jpg");
		FoodDto food5 = new FoodDto("5", "������Ű«��", 4, "�Ͻ�", 6000, "/kitri/foodCourt/user/basket/image/����1.jpg");
		BasketDetail detail1 = new BasketDetail(food1, 1);
		BasketDetail detail2 = new BasketDetail(food2, 2);
		BasketDetail detail3 = new BasketDetail(food3, 3);
		BasketDetail detail4 = new BasketDetail(food4, 4);
		BasketDetail detail5 = new BasketDetail(food4, 5);
		
		user.getBasket().add(detail1);
		user.getBasket().add(detail2);
		user.getBasket().add(detail3);
		user.getBasket().add(detail4);
		user.getBasket().add(detail5);
		
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BasketMain frame = new BasketMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BasketMain() {
		test();
		
		//�⺻ UI ����
		controller = new BasketController(this);
		initView();
		dataSetting();
		
		//�̺�Ʈ
		btnAllCancel.addActionListener(controller);
		btnPayment.addActionListener(controller);
		
		
	}
	public void initView() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 800);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setToolTipText("\uC804\uCCB4\uC120\uD0DD");
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(0, 10, 1172, 6);
		panel.add(panel_5);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 102, 1172, 6);
		panel.add(panel_3);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(146, 118, 5, 476);
		panel.add(panel_6);
		
		JButton btnOrderList = new JButton(new ImageIcon(BasketMain.class.getResource("/kitri/foodCourt/user/menu/mainImage/basket.png")));
		btnOrderList.setToolTipText("\uC8FC\uBB38\uBAA9\uB85D");
		btnOrderList.setBorder(new LineBorder(Color.GRAY, 2, true));
		btnOrderList.setBounds(1074, 26, 79, 54);
		panel.add(btnOrderList);
		
		//����
		pChangePanel = new JPanel();
		pChangePanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		pChangePanel.setBounds(163, 118, 1021, 643);
		panel.add(pChangePanel);
		card = new CardLayout();
		pChangePanel.setLayout(card);
		
		pBasketMain = new JPanel();
		pBasketMain.setBounds(160, 118, 1012, 634);
		pBasketMain.setLayout(null);
		
		btnAllCancel = SwingFactory.getInstance().getButton("x");
		btnAllCancel.setName("allCancel");
		btnAllCancel.setBounds(29, 2, 44, 44);
		
		JPanel pTop = new JPanel();
		pTop.setBounds(0, 0, 1000, 155);
		pBasketMain.add(pTop);
		pTop.setLayout(null);
		
		JLabel lblBasketImage = new JLabel("");
		lblBasketImage.setBounds(12, 10, 120, 70);
		pTop.add(lblBasketImage);
		lblBasketImage.setIcon(new ImageIcon(this.getClass().getResource("/kitri/foodCourt/user/basket/image/Basket1.png")));
		
		FLabel lblBasket = new FLabel(Font.BOLD, 40);
		lblBasket.setBounds(144, 10, 178, 70);
		pTop.add(lblBasket);
		lblBasket.setText("\uC7A5\uBC14\uAD6C\uB2C8");
		
		JPanel pSeparator = new JPanel();
		pSeparator.setBounds(12, 90, 988, 6);
		pTop.add(pSeparator);
		pSeparator.setBackground(SystemColor.activeCaption);
		
		JPanel pBasketMenu = new JPanel();
		pBasketMenu.setBounds(12, 106, 988, 50);
		pTop.add(pBasketMenu);
		pBasketMenu.setBackground(SystemColor.inactiveCaptionBorder);
		pBasketMenu.setLayout(null);
		pBasketMenu.add(btnAllCancel);
		
		FLabel label_1 = new FLabel(Font.PLAIN, 20);
		label_1.setText("\uC0C1\uD488\uC815\uBCF4");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(210, 0, 134, 50);
		pBasketMenu.add(label_1);
		
		FLabel label_3 = new FLabel(Font.PLAIN, 20);
		label_3.setText("\uD3EC\uC778\uD2B8");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setBounds(520, 0, 100, 50);
		pBasketMenu.add(label_3);
		
		FLabel label_4 = new FLabel(Font.PLAIN, 20);
		label_4.setText("\uAC00\uACA9");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setBounds(850, 0, 100, 50);
		pBasketMenu.add(label_4);
		
		FLabel label_5 = new FLabel(Font.PLAIN, 20);
		label_5.setText("\uC218\uB7C9");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setBounds(695, 0, 100, 50);
		pBasketMenu.add(label_5);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(12, 165, 988, 304);
		pBasketMain.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panel_1.add(scrollPane);
		
		pMiddle = new JPanel();
		scrollPane.setViewportView(pMiddle);
		gbl_pMiddle = new GridBagLayout();
		gbl_pMiddle.columnWidths = new int[]{0};
		gbl_pMiddle.rowHeights = new int[]{0, 0, 0};
		gbl_pMiddle.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pMiddle.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		pMiddle.setLayout(gbl_pMiddle);
		
		JPanel pBottom = new JPanel();
		pBottom.setBounds(0, 479, 1010, 155);
		pBasketMain.add(pBottom);
		pBottom.setLayout(null);
		
		//��Ż�κ�
		JPanel pTotal = new JPanel();
		pTotal.setBounds(12, 0, 988, 85);
		pBottom.add(pTotal);
		pTotal.setBackground(SystemColor.inactiveCaptionBorder);
		pTotal.setLayout(null);
		
		FLabel lblPrice = new FLabel(Font.BOLD, 30);
		lblPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrice.setText("\uCD1D \uACB0\uC81C\uAE08\uC561");
		lblPrice.setBounds(578, 0, 179, 50);
		pTotal.add(lblPrice);
		
		lblTotalPrice = new FLabel(Font.BOLD, 30);
		lblTotalPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotalPrice.setBounds(765, 0, 196, 50);
		pTotal.add(lblTotalPrice);
		
		lblTotalPoint = new FLabel(Font.BOLD, 20);
		lblTotalPoint.setHorizontalAlignment(SwingConstants.RIGHT);
		
		lblTotalPoint.setBounds(837, 50, 124, 35);
		pTotal.add(lblTotalPoint);
		
		FLabel lblPoint = new FLabel(Font.BOLD, 20);
		lblPoint.setText("\uC801\uB9BD \uD3EC\uC778\uD2B8");
		lblPoint.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPoint.setBounds(710, 50, 115, 35);
		pTotal.add(lblPoint);
		
		btnPayment = SwingFactory.getButton("");
		btnPayment.setName("payment");
		btnPayment.setBounds(831, 95, 169, 47);
		pBottom.add(btnPayment);
		btnPayment.setFont(new Font("���� ����", Font.BOLD, 20));
		btnPayment.setText("\uACB0\uC81C");
		
		//ī��κ�
		pChangePanel.add(pBasketMain, "basket");
		card.show(pChangePanel, "basket");
		
	}
	
	public void dataSetting() {
		//��Ż����
		lblTotalPrice.setText(String.valueOf(user.getBasket().getTotalPrice()));
		lblTotalPoint.setText(String.valueOf(user.getBasket().getSavePoint()));
		
		pMiddle = new JPanel();
		scrollPane.setViewportView(pMiddle);
		gbl_pMiddle = new GridBagLayout();
		gbl_pMiddle.columnWidths = new int[]{0};
		gbl_pMiddle.rowHeights = new int[]{0, 0, 0};
		gbl_pMiddle.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pMiddle.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		pMiddle.setLayout(gbl_pMiddle);
		
		//�ٽ��Ͽ� �ִ� �������� �Ѹ���
		int size = user.getBasket().getDetailList().size();
		for(int i = 0; i<size ; i++) {
			JPanel temp = addFood(i);
			GridBagConstraints gbcFood = new GridBagConstraints();
			gbcFood.insets = new Insets(0, 0, 0, 0);
			gbcFood.fill = GridBagConstraints.HORIZONTAL;
			gbcFood.gridx = 0;
			gbcFood.gridy = i;
			
			pMiddle.add(temp, gbcFood);
		}
	}
	
	public JPanel addFood(int index) {
		BasketDetail detail = user.getBasket().getDetailList().get(index);
		JPanel pFood = new JPanel();
		pFood.setLayout(null);
		pFood.setMaximumSize(new Dimension(988, 100));
		pFood.setPreferredSize(new Dimension(988, 100));
		//x��ư
		FButton btnX = SwingFactory.getInstance().getButton("x");
		btnX.setName(index+"cancel");
		btnX.setBounds(29, 28, 44, 44);
		pFood.add(btnX);
		btnX.setName("x"+index);
		
		//���ļ����� �г� - ���� Ŭ���ϸ� ȿ������
		FPanel pFoodInfo = SwingFactory.getInstance().getPanel("basketFood");
		pFoodInfo.setBounds(93, 0, 350, 100);
		pFood.add(pFoodInfo);
		
		//���Ļ���
		FButton btnFoodImage = SwingFactory.getInstance().getButton("image");
		URL url = BasketMain.class.getResource(detail.getFood().getImageAddress());
		if(url != null) {
			btnFoodImage.setIcon(new ImageIcon(url));
		}
		btnFoodImage.setBounds(12, 15, 120, 70);
		pFoodInfo.add(btnFoodImage);
		
		//�����̸�
		FLabel lFoodName = SwingFactory.getInstance().getLabel("basketFood");
		lFoodName.setText(detail.getFood().getFoodName());
		lFoodName.setHorizontalAlignment(SwingConstants.LEFT);
		lFoodName.setBounds(144, 15, 190, 70);
		pFoodInfo.add(lFoodName);
		
		//����Ʈ
		FLabel lPoint = SwingFactory.getInstance().getLabel("basketFood");
		lPoint.setText(String.valueOf(detail.getFood().getPoint()));
		lPoint.setBounds(520, 28, 100, 44);
		pFood.add(lPoint);
		
		//����
		FLabel lCount = SwingFactory.getInstance().getLabel("basketFood");
		lCount.setText(String.valueOf(detail.getCount()));
		lCount.setBounds(695, 28, 100, 45);
		pFood.add(lCount);
		
		//����
		FLabel lPrice = SwingFactory.getInstance().getLabel("basketFood");
		lPrice.setText(String.valueOf(detail.getFood().getPrice()));
		lPrice.setBounds(850, 28, 100, 45);
		pFood.add(lPrice);
		
		//�̺�Ʈ
		btnX.addActionListener(controller);
		pFoodInfo.setController(controller);
		
		return pFood;
	}
}