package Pages;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

import database.PaymentNum;
import database.SelectNum;
import database.SelectNumData;
import utility.IconData;
import utility.Utility;

public class MyNumCheckPage extends JDialog {
	private JLayeredPane layeredPane;
	private Utility utility = new Utility();
	private JLabel[][] lottoNum2;
	private BuyPage buyPage = new BuyPage();
	private PaymentNum[] payNumArr;
	private JLabel[] lottoAutos;
	private IconData iconData = new IconData();

	/**
	 * Create the frame.
	 */
	public MyNumCheckPage() {

		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModal(true);
		setResizable(false); // 창 크기 변경을 비활성화

		// 이미지 아이콘을 사용하는 레이블 생성
		JLabel label = new JLabel(iconData.myNumCheckIcon());
		lottoNum2 = new JLabel[8][10];
		lottoAutos = new JLabel[10];
		JLabel[] winnerNum = new JLabel[10];

		JLabel bonusNum = new JLabel();
		bonusNum.setBounds(357, 225, 40, 40);

		layeredPane = new JLayeredPane();
		layeredPane.setPreferredSize(
				new Dimension(iconData.winningNumIcon().getIconWidth(), iconData.winningNumIcon().getIconHeight()));

		for (int j = 0; j < 10; j++) {
			for (int i = 0; i < 6; i++) {
				if (i == 0) {
					lottoNum2[i][j] = new JLabel();

				} else {
					lottoNum2[i][j] = new JLabel();

				}
				lottoNum2[i][j].setBounds(72 + i * 44, 340 + j * 50, 36, 36);
				layeredPane.add(lottoNum2[i][j], new Integer(2));

			}
		}

		// 자동 반자동 수동 //할 일 자동 반자동 이미지 수정하기ㅁ
		for (int i = 0; i < 10; i++) {
			lottoAutos[i] = new JLabel();
			lottoAutos[i].setBounds(337, 340 + i * 50, 52, 36);
			layeredPane.add(lottoAutos[i], new Integer(2));
		}
		// 당첨된 번호
		for (int i = 0; i < 6; i++) {
			winnerNum[i] = new JLabel();// 각 배열원소는 라벨이미지
			winnerNum[i].setBounds(33 + (i * 50), 225, 40, 40);// 위치
			layeredPane.add(winnerNum[i], new Integer(2));// 레이어드패널에 추가 각 배열원소
		}

		// 버튼 생성
		JButton backBtn = new JButton(iconData.backIcon());
		backBtn.setBounds(18, 45, 38, 33); // 위치와 크기 설정

		// 레이블 및 버튼 위치 설정
		label.setBounds(0, 0, iconData.winningNumIcon().getIconWidth(), iconData.winningNumIcon().getIconHeight());

		// 레이블 및 버튼을 JLayeredPane에 추가
		layeredPane.add(label, new Integer(1)); // 레이블은 뒤쪽 레이어에 추가
		layeredPane.add(backBtn, new Integer(2)); // 버튼은 앞쪽 레이어에 추가
		layeredPane.add(bonusNum, new Integer(2));

		// JLayeredPane을 프레임의 contentPane에 추가
		setContentPane(layeredPane);
		pack();
		// showSelectedNum();

		backBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		utility.setButtonProperties(backBtn);
		// 구입한 번호의 이미지 변경
//		getChangeNumsImage();
		showPaymentNum();
	}
	private void showPaymentNum() {
	    System.out.println("진입 showPaymentNum ");
	    for (Integer key : buyPage.PAYMENT_NUM_DATA.getPaymentMap().keySet()) {
	        Integer[] paymentNum = buyPage.PAYMENT_NUM_DATA.getPaymentMap().get(key).getPaymentNum();
	        System.out.println(key);
	        Integer i = 0;
	        for (Integer integer : paymentNum) {
	                lottoNum2[i][key - 1].setIcon(iconData.SIcons()[integer]);
	            i++;
	            System.out.println(integer);
	        }
	        if (buyPage.PAYMENT_NUM_DATA.getPaymentMap().get(key).getAutoStat() == 1) {
	            lottoAutos[key - 1].setIcon(iconData.autoIcon());
	        }
	        if (buyPage.PAYMENT_NUM_DATA.getPaymentMap().get(key).getAutoStat() == 2) {
	            lottoAutos[key - 1].setIcon(iconData.semiAutoIcon());
	        }
	        if (buyPage.PAYMENT_NUM_DATA.getPaymentMap().get(key).getAutoStat() == 3) {
	            lottoAutos[key - 1].setIcon(iconData.manualIcon());
	        }

	    }
	}


}