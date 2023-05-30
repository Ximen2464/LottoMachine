package Pages;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database.SelectNum;
import database.SelectNumMap;
import database.WinningNum;
import utility.IconData;

public class WinningNumPage extends JDialog {
	private IconData icon = new IconData();
	private JPanel contentPane;
	private JLayeredPane layeredPane;
	private int[] Num;
	private int i;

  
    /**
     * Create the frame.
     */
    public WinningNumPage() {
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setModal(true);
        setResizable(false); // 창 크기 변경을 비활성화

     // 이미지 아이콘을 사용하는 레이블 생성
        JLabel label = new JLabel(icon.winningNumIcon());
        
        JLabel[][] lottoNum = new JLabel[8][10];
        JLabel[][] lottoNum2 = new JLabel[8][10];
        JLabel[] lottoAuto = new JLabel[10];
        JLabel[] winnerNum = new JLabel[10];
        
        JLabel bonusNum = new JLabel(icon.emptyBtn());
        bonusNum.setBounds(357, 225, 40, 40);
        
        
        
        Map<Integer, SelectNum> map;
        layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(icon.winningNumIcon().getIconWidth(), icon.winningNumIcon().getIconHeight()));
        
        int[] arr = new int[6];
        
        	for (int j = 0; j < 10; j++) {
        		for (int i = 0; i < 7; i++) {
        			if(i == 0) {
        				lottoNum[i][j] = new JLabel();
        				
        			} else {
        				lottoNum[i][j] = new JLabel(icon.emptySBtn());
        			}
        			
        			lottoNum[i][j].setBounds(28 + i * 44, 340 + j * 50, 36, 36);
        			layeredPane.add(lottoNum[i][j], new Integer(2));	
        		}
        	}
        	
        	for (int i = 0; i < 10; i++) {
        		lottoAuto[i]= new JLabel(icon.emptyLBtn());
        		lottoAuto[i].setBounds(337, 340 + i * 50, 52, 36);
        		layeredPane.add(lottoAuto[i], new Integer(2));
        	}
        	
        	for (int i = 0; i < 6; i++) {
        		winnerNum[i]= new JLabel(icon.emptyBtn());
        		winnerNum[i].setBounds(33 + (i * 50), 225, 40, 40);
        		layeredPane.add(winnerNum[i], new Integer(2));
        	}
        	
        	
        	
        	
        
        // 버튼 생성
        JButton backBtn = new JButton(icon.backIcon());
        backBtn.setBounds(18, 45, 38, 33); // 위치와 크기 설정


        // 레이블 및 버튼 위치 설정
        label.setBounds(0, 0, icon.winningNumIcon().getIconWidth(), icon.winningNumIcon().getIconHeight());

        // 레이블 및 버튼을 JLayeredPane에 추가
        layeredPane.add(label, new Integer(1)); // 레이블은 뒤쪽 레이어에 추가
        layeredPane.add(backBtn, new Integer(2)); // 버튼은 앞쪽 레이어에 추가
        layeredPane.add(bonusNum, new Integer(2));
        
        
        // JLayeredPane을 프레임의 contentPane에 추가
        setContentPane(layeredPane);
        

        pack();
        
        backBtn.setOpaque(false);
        backBtn.setContentAreaFilled(false);
        backBtn.setBorderPainted(false);
    }
    private void winningNum() {
    	SelectNumMap sm = new SelectNumMap();
    	SelectNum num = new SelectNum(Num, i);
    	
    	boolean added = sm.addLinkedHashMap(num);
    	if (added) {
    	    // LinkedHashMap에 추가되었을 때의 처리
    	} else {
    	    // LinkedHashMap의 크기가 10 이상일 때의 처리
    	}
    	
    }
}