package Pages;
import java.awt.Dimension;

import database.SelectNum;
import database.SelectNumHashMap;
import utility.IconData;
import utility.Utility;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class SelectNumPage extends JDialog {

    private JPanel contentPane;
    SelectNumHashMap selectNumHashMap = new SelectNumHashMap();
    private IconData iconData = new IconData();
	private JLabel[][] numLabels;
    private Utility utility = new Utility();
	private JLabel[] keyLabels;
	
   
    /**
     * Create the frame.
     */
    public SelectNumPage() {

        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setModal(true);
        setResizable(false); // 창 크기 변경을 비활성화
        
        // 이미지 아이콘 로드
        ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("selectNum(BG).png"));
        ImageIcon backIcon = new ImageIcon(getClass().getClassLoader().getResource("backBtn.png"));
        ImageIcon buyIcon = new ImageIcon(getClass().getClassLoader().getResource("buyBtn.png"));
        ImageIcon numIcon = new ImageIcon(getClass().getClassLoader().getResource("emptyBtn.png"));
        ImageIcon cancleBtn = new ImageIcon(getClass().getClassLoader().getResource("cancleBtn.png"));
        
        numLabels = new JLabel[6][10];
        keyLabels = new JLabel[10];
        // 이미지 아이콘을 사용하는 레이블 생성
        JLabel label = new JLabel(icon); // 배경 Label
        
        for (int i = 0; i < numLabels.length; i++) { // 로또 번호 저장 Label
			for (int j = 0; j < numLabels[i].length; j++) {
				numLabels[i][j] = new JLabel(numIcon);
			}
		}
        
        for (int i = 0; i < keyLabels.length; i++) { // key 저장 Label
			keyLabels[i] = new JLabel();
			
		}

        // 버튼 생성
        JButton backButton = new JButton(backIcon);
        backButton.setBounds(20, 41, 33, 38); // 위치와 크기 설정
       
        JButton buyButton = new JButton(buyIcon);
        buyButton.setBounds(90, 815, 251, 41); // 위치와 크기 설정

        // JLayeredPane 생성 및 설정
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(430, 890)); // JLayeredPane의 크기 설정

        JButton[] cancel = new JButton[10];
        for(int i = 0; i < 10; i++) {
        	cancel[i] = new JButton(cancleBtn);
        	cancel[i].setBounds(356, 119 + i * 70, 52, 36);
        	layeredPane.add(cancel[i], new Integer(2));
        	utility.setButtonProperties(cancel[i]);
        }
        
        // 레이블 및 버튼 위치 설정
        label.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight()); // 배경 위치
        
        for (int i = 0; i < numLabels.length; i++) { // 로또 번호 저장소 위치
			for (int j = 0; j < numLabels[i].length; j++) {
				numLabels[i][j].setBounds(52 + i * 50, 117 + j * 70, 40, 40);
			}
		}

        for (int i = 0; i < numLabels.length; i++) { 
			for (int j = 0; j < numLabels[i].length; j++) {
				layeredPane.add(numLabels[i][j], new Integer(2)); // 레이블은 앞쪽에 레이어에 추가 
			}
		}
        
        for (int i = 0; i < keyLabels.length; i++) {
			layeredPane.add(keyLabels[i], new Integer(2));
		}
        layeredPane.add(label, new Integer(1)); // 레이블은 뒤쪽 레이어에 추가
        layeredPane.add(backButton, new Integer(2)); // 버튼은 앞쪽 레이어에 추가
        layeredPane.add(buyButton, new Integer(2)); // 버튼은 앞쪽 레이어에 추가

        // JLayeredPane을 프레임의 contentPane에 추가
        setContentPane(layeredPane);
        
        // 버튼숨기기
        utility.setButtonProperties(backButton);
        utility.setButtonProperties(buyButton);
        
        // 버튼 ActionListener
        
        backButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				 dispose();
				  BuyPage buyPage = new BuyPage();
				  buyPage.setVisible(true);
				  buyPage.setAlwaysOnTop(true);
				
			}
		});
        
        buyButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				BuyCheckPage buyCheckPage = new BuyCheckPage();
				dispose();
				
				buyCheckPage.setAlwaysOnTop(true);
				buyCheckPage.setVisible(true);
				
			}
		});
        pack();
        
        
       
    }
}
