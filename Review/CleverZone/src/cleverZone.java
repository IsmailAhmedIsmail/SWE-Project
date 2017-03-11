import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.util.Vector;
import java.awt.event.ActionEvent;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JPasswordField;
import javax.swing.JFormattedTextField;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;

public class cleverZone {
	
	private String gameTypeStr = ""; // needed in "get selected subjects & show games buttons in playGame Panel"

	private JFrame frm_CreategGame;
	private Control control = new Control();
	private JTextField mcqTmpQuesTxtField;
	private JTextField mcqTmpCho1TxtField;
	private JTextField mcqTmpCho2TxtField;
	private JTextField mcqTmpCho3TxtField;
	private JTextField mcqTmpCho4TxtField;
	private JTextField mcqTmpAnsTxtField;
	private final ButtonGroup createGameGameTypebuttonGroup = new ButtonGroup();
	private JTextField mtTmpLefttxtfield1;
	private JTextField mtTmpLefttxtfield2;
	private JTextField mtTmpLefttxtfield3;
	private JTextField mtTmpLefttxtfield4;
	private JTextField mtTmpLefttxtfieldA;
	private JTextField mtTmpLefttxtfieldB;
	private JTextField mtTmpLefttxtfieldC;
	private JTextField mtTmpLefttxtfieldD;
	private JTextField mtTmpAns1;
	private JTextField mtTmpAns2;
	private JTextField mtTmpAns3;
	private JTextField mtTmpAns4;
	private JTextField t_fTmpQuesTxtField;
	private JTextField t_fTmpAnsTxtField;
	
	private String Subject;
	private String Name;
		
	private McQ McQ_Game = new McQ();
	private Match match_game = new Match();
	private T_F tfGame = new T_F();
	
	private int McQCnt=0;//index for the current mcq question
	private int	T_FCnt=0;//index for the current t/f question
	private int MatchCnt=0;//index for the current match question
	
	Account theAccount  = new Account();
	
	private JTextField createGameGameNameTxtField;
	private JTextField createGameGameSubjectTxtField;
	private JPasswordField loginPasswordTxtField;
	private JTextField loginUsernameTxtField;
	private JTextField registerNameTxtField;
	private JTextField registerUserNameTxtField;
	private JTextField registerEmailTxtField;
	private JPasswordField registerPasswordTxtField;
	private JPasswordField registerConfirmPasswordTxtField;
	private final ButtonGroup registerTypeButtonGroup = new ButtonGroup();
	private final ButtonGroup registerGenderButtonGroup = new ButtonGroup();
	private JTextField mcqGameQuesTxtField;
	private final ButtonGroup mcqGameChoicesButtonGroup = new ButtonGroup();
	private JTextField t_fGameQuesTxtField;
	private final ButtonGroup t_fGameButtonGroup = new ButtonGroup();
	private JTextField mtGameLeft1TxtField;
	private JTextField mtGameLeft2TxtField;
	private JTextField mtGameLeft3TxtField;
	private JTextField mtGameLeft4TxtField;
	private JTextField mtGameRightATxtField;
	private JTextField mtGameRightBTxtField;
	private JTextField mtGameRightCTxtField;
	private JTextField mtGameRightDTxtField;
	private final ButtonGroup mtGameButtonGroup1 = new ButtonGroup();
	private final ButtonGroup mtGameButtonGroup2 = new ButtonGroup();
	private final ButtonGroup mtGameButtonGroup3 = new ButtonGroup();
	private final ButtonGroup mtGameButtonGroup4 = new ButtonGroup();
	private final ButtonGroup PlayGameGameTypeButtonGroup = new ButtonGroup();

	
	
	/* Extra Work By Our Team
	  
	*/
	JButton t_fTmpBtnAddQ;
	ActionListener t_fTmpBtnAddQActionListener = new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			if(t_fTmpQuesTxtField.getText().isEmpty() || t_fTmpAnsTxtField.getText().isEmpty()){
				JOptionPane.showMessageDialog(null, "Please enter all the data ");
			}else{
				T_FQuestion t = new T_FQuestion(t_fTmpQuesTxtField.getText(), t_fTmpAnsTxtField.getText());
				tfGame.AddQuestion(t);
				t_fTmpQuesTxtField.setText("");
				t_fTmpAnsTxtField.setText("");
			}
		}
	};
	
	public JTextField getT_fTmpQuesTxtField() {
		return t_fTmpQuesTxtField;
	}

	public T_F getTfGame() {
		return tfGame;
	}
	public JTextField getT_fTmpAnsTxtField() {
		return t_fTmpAnsTxtField;
	}

	/*
	 * done
	 */
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cleverZone window = new cleverZone();
					window.frm_CreategGame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public cleverZone() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frm_CreategGame = new JFrame();
		frm_CreategGame.setTitle("Clever Zone");
		frm_CreategGame.setBounds(100, 100, 850, 500);
		frm_CreategGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm_CreategGame.getContentPane().setLayout(new CardLayout(0, 0));
		
		JButton playGameBtnGetSubjects = new JButton("Get Selected Subjects");
		playGameBtnGetSubjects.setFont(new Font("Chiller", Font.BOLD, 18));
		JPanel homePanel = new JPanel();
		frm_CreategGame.getContentPane().add(homePanel, "name_19208349551372");
		homePanel.setLayout(null);
		homePanel.setVisible(true);
		
		
		JPanel registerPanel = new JPanel();
		frm_CreategGame.getContentPane().add(registerPanel, "name_23837330151410");
		registerPanel.setLayout(null);
		registerPanel.setVisible(false);
		
		JPanel loginPanel = new JPanel();
		frm_CreategGame.getContentPane().add(loginPanel, "name_23376607050557");
		loginPanel.setLayout(null);
		loginPanel.setVisible(false);
		
		
		JPanel createGamePanel = new JPanel();
		frm_CreategGame.getContentPane().add(createGamePanel, "name_20877916505726");
		createGamePanel.setLayout(null);
		createGamePanel.setVisible(false);
		
		JPanel sProfilePanel = new JPanel();
		frm_CreategGame.getContentPane().add(sProfilePanel, "name_26370065916662");
		sProfilePanel.setLayout(null);
		sProfilePanel.setVisible(false);
		
		JPanel tProfilePanel = new JPanel();
		frm_CreategGame.getContentPane().add(tProfilePanel, "name_27465590731761");
		tProfilePanel.setLayout(null);
		tProfilePanel.setVisible(false);
		
		JPanel playGamePanel = new JPanel();
		frm_CreategGame.getContentPane().add(playGamePanel, "name_30648042944926");
		playGamePanel.setLayout(null);
		playGamePanel.setVisible(false);
		
		JPanel mcqGamePanel = new JPanel();
		frm_CreategGame.getContentPane().add(mcqGamePanel, "name_90324256806965");
		mcqGamePanel.setLayout(null);
		mcqGamePanel.setVisible(false);
		
		JPanel t_fGamePanel = new JPanel();
		frm_CreategGame.getContentPane().add(t_fGamePanel, "name_91870340021553");
		t_fGamePanel.setLayout(null);
		t_fGamePanel.setVisible(false);
		
		JPanel mtGamePanel = new JPanel();
		frm_CreategGame.getContentPane().add(mtGamePanel, "name_93563546412412");
		mtGamePanel.setLayout(null);
		mtGamePanel.setVisible(false);
		
		JLabel label_35 = new JLabel("Matching Game");
		label_35.setFont(new Font("Chiller", Font.BOLD, 40));
		label_35.setBounds(271, 11, 203, 61);
		mtGamePanel.add(label_35);
		mtGamePanel.setVisible(false);
		
		JLabel lblNewLabel_10 = new JLabel("A");
		lblNewLabel_10.setFont(new Font("Chiller", Font.BOLD, 20));
		lblNewLabel_10.setBounds(10, 108, 20, 24);
		mtGamePanel.add(lblNewLabel_10);
		
		JPanel mtGameChoicesInternalPanel = new JPanel();
		mtGameChoicesInternalPanel.setBorder(new TitledBorder(null, "Match", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		mtGameChoicesInternalPanel.setBounds(10, 187, 710, 199);
		mtGamePanel.add(mtGameChoicesInternalPanel);
		mtGameChoicesInternalPanel.setLayout(null);
		
		JLabel label_36 = new JLabel("1");
		label_36.setFont(new Font("Chiller", Font.BOLD, 20));
		label_36.setBounds(12, 40, 27, 20);
		mtGameChoicesInternalPanel.add(label_36);
		
		JLabel label_37 = new JLabel("2");
		label_37.setFont(new Font("Chiller", Font.BOLD, 20));
		label_37.setBounds(10, 80, 27, 20);
		mtGameChoicesInternalPanel.add(label_37);
		
		JLabel label_38 = new JLabel("3");
		label_38.setFont(new Font("Chiller", Font.BOLD, 20));
		label_38.setBounds(10, 120, 27, 20);
		mtGameChoicesInternalPanel.add(label_38);
		
		JLabel label_39 = new JLabel("4");
		label_39.setFont(new Font("Chiller", Font.BOLD, 20));
		label_39.setBounds(10, 160, 27, 20);
		mtGameChoicesInternalPanel.add(label_39);
		
		mtGameLeft1TxtField = new JTextField();
		mtGameLeft1TxtField.setColumns(10);
		mtGameLeft1TxtField.setBounds(47, 40, 183, 20);
		mtGameChoicesInternalPanel.add(mtGameLeft1TxtField);
		
		mtGameLeft2TxtField = new JTextField();
		mtGameLeft2TxtField.setColumns(10);
		mtGameLeft2TxtField.setBounds(47, 80, 183, 20);
		mtGameChoicesInternalPanel.add(mtGameLeft2TxtField);
		
		mtGameLeft3TxtField = new JTextField();
		mtGameLeft3TxtField.setColumns(10);
		mtGameLeft3TxtField.setBounds(47, 120, 183, 20);
		mtGameChoicesInternalPanel.add(mtGameLeft3TxtField);
		
		mtGameLeft4TxtField = new JTextField();
		mtGameLeft4TxtField.setColumns(10);
		mtGameLeft4TxtField.setBounds(47, 160, 183, 20);
		mtGameChoicesInternalPanel.add(mtGameLeft4TxtField);
		
		JRadioButton mtGameRdBtnA1 = new JRadioButton("A");
		mtGameButtonGroup1.add(mtGameRdBtnA1);
		mtGameRdBtnA1.setFont(new Font("Chiller", Font.BOLD, 20));
		mtGameRdBtnA1.setBounds(301, 40, 42, 23);
		mtGameChoicesInternalPanel.add(mtGameRdBtnA1);
		
		JRadioButton mtGameRdBtnB1 = new JRadioButton("B");
		mtGameButtonGroup1.add(mtGameRdBtnB1);
		mtGameRdBtnB1.setFont(new Font("Chiller", Font.BOLD, 20));
		mtGameRdBtnB1.setBounds(372, 40, 42, 23);
		mtGameChoicesInternalPanel.add(mtGameRdBtnB1);
		
		JRadioButton mtGameRdBtnC1 = new JRadioButton("C");
		mtGameButtonGroup1.add(mtGameRdBtnC1);
		mtGameRdBtnC1.setFont(new Font("Chiller", Font.BOLD, 20));
		mtGameRdBtnC1.setBounds(443, 40, 42, 23);
		mtGameChoicesInternalPanel.add(mtGameRdBtnC1);
		
		JRadioButton mtGameRdBtnD1 = new JRadioButton("D");
		mtGameButtonGroup1.add(mtGameRdBtnD1);
		mtGameRdBtnD1.setFont(new Font("Chiller", Font.BOLD, 20));
		mtGameRdBtnD1.setBounds(514, 40, 42, 23);
		mtGameChoicesInternalPanel.add(mtGameRdBtnD1);
		
		JRadioButton mtGameRdBtnA2 = new JRadioButton("A");
		mtGameButtonGroup2.add(mtGameRdBtnA2);
		mtGameRdBtnA2.setFont(new Font("Chiller", Font.BOLD, 20));
		mtGameRdBtnA2.setBounds(301, 80, 42, 23);
		mtGameChoicesInternalPanel.add(mtGameRdBtnA2);
		
		JRadioButton mtGameRdBtnB2 = new JRadioButton("B");
		mtGameButtonGroup2.add(mtGameRdBtnB2);
		mtGameRdBtnB2.setFont(new Font("Chiller", Font.BOLD, 20));
		mtGameRdBtnB2.setBounds(372, 80, 42, 23);
		mtGameChoicesInternalPanel.add(mtGameRdBtnB2);
		
		JRadioButton mtGameRdBtnC2 = new JRadioButton("C");
		mtGameButtonGroup2.add(mtGameRdBtnC2);
		mtGameRdBtnC2.setFont(new Font("Chiller", Font.BOLD, 20));
		mtGameRdBtnC2.setBounds(443, 80, 42, 23);
		mtGameChoicesInternalPanel.add(mtGameRdBtnC2);
		
		JRadioButton mtGameRdBtnD2 = new JRadioButton("D");
		mtGameButtonGroup2.add(mtGameRdBtnD2);
		mtGameRdBtnD2.setFont(new Font("Chiller", Font.BOLD, 20));
		mtGameRdBtnD2.setBounds(514, 80, 42, 23);
		mtGameChoicesInternalPanel.add(mtGameRdBtnD2);
		
		JRadioButton mtGameRdBtnA3 = new JRadioButton("A");
		mtGameButtonGroup3.add(mtGameRdBtnA3);
		mtGameRdBtnA3.setFont(new Font("Chiller", Font.BOLD, 20));
		mtGameRdBtnA3.setBounds(301, 120, 42, 23);
		mtGameChoicesInternalPanel.add(mtGameRdBtnA3);
		
		JRadioButton mtGameRdBtnB3 = new JRadioButton("B");
		mtGameButtonGroup3.add(mtGameRdBtnB3);
		mtGameRdBtnB3.setFont(new Font("Chiller", Font.BOLD, 20));
		mtGameRdBtnB3.setBounds(372, 120, 42, 23);
		mtGameChoicesInternalPanel.add(mtGameRdBtnB3);
		
		JRadioButton mtGameRdBtnC3 = new JRadioButton("C");
		mtGameButtonGroup3.add(mtGameRdBtnC3);
		mtGameRdBtnC3.setFont(new Font("Chiller", Font.BOLD, 20));
		mtGameRdBtnC3.setBounds(443, 120, 42, 23);
		mtGameChoicesInternalPanel.add(mtGameRdBtnC3);
		
		JRadioButton mtGameRdBtnD3 = new JRadioButton("D");
		mtGameButtonGroup3.add(mtGameRdBtnD3);
		mtGameRdBtnD3.setFont(new Font("Chiller", Font.BOLD, 20));
		mtGameRdBtnD3.setBounds(514, 120, 42, 23);
		mtGameChoicesInternalPanel.add(mtGameRdBtnD3);
		
		JRadioButton mtGameRdBtnA4 = new JRadioButton("A");
		mtGameButtonGroup4.add(mtGameRdBtnA4);
		mtGameRdBtnA4.setFont(new Font("Chiller", Font.BOLD, 20));
		mtGameRdBtnA4.setBounds(301, 160, 42, 23);
		mtGameChoicesInternalPanel.add(mtGameRdBtnA4);
		
		JRadioButton mtGameRdBtnB4 = new JRadioButton("B");
		mtGameButtonGroup4.add(mtGameRdBtnB4);
		mtGameRdBtnB4.setFont(new Font("Chiller", Font.BOLD, 20));
		mtGameRdBtnB4.setBounds(372, 160, 42, 23);
		mtGameChoicesInternalPanel.add(mtGameRdBtnB4);
		
		JRadioButton mtGameRdBtnC4 = new JRadioButton("C");
		mtGameButtonGroup4.add(mtGameRdBtnC4);
		mtGameRdBtnC4.setFont(new Font("Chiller", Font.BOLD, 20));
		mtGameRdBtnC4.setBounds(443, 160, 42, 23);
		mtGameChoicesInternalPanel.add(mtGameRdBtnC4);
		
		JRadioButton mtGameRdBtnD4 = new JRadioButton("D");
		mtGameButtonGroup4.add(mtGameRdBtnD4);
		mtGameRdBtnD4.setFont(new Font("Chiller", Font.BOLD, 20));
		mtGameRdBtnD4.setBounds(514, 160, 42, 23);
		mtGameChoicesInternalPanel.add(mtGameRdBtnD4);
		
		JButton mtGameBtnShowAns = new JButton("Show Answer");
		mtGameBtnShowAns.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, match_game.Questions.get(0).AnswerA.get(0)+" "+match_game.Questions.get(0).AnswerB.get(0)+"\n"+
						match_game.Questions.get(0).AnswerA.get(1)+" "+match_game.Questions.get(0).AnswerB.get(1)+"\n"+
						match_game.Questions.get(0).AnswerA.get(2)+" "+match_game.Questions.get(0).AnswerB.get(2)+"\n"+
						
						match_game.Questions.get(0).AnswerA.get(3)+" "+match_game.Questions.get(0).AnswerB.get(3)+"\n");
				MatchCnt++;
				if(MatchCnt==match_game.GetQuestions().size())
				{
					JOptionPane.showMessageDialog(null, "ConGraTulationsssssSSsSSssSss");
					mtGamePanel.setVisible(false);
					playGamePanel.setVisible(true);
				}
				else
				{
					
					mtGameRightATxtField.setText(match_game.Questions.get(MatchCnt).GetQuestionA().get(0));
					mtGameRightBTxtField.setText(match_game.Questions.get(MatchCnt).GetQuestionA().get(1));
					mtGameRightCTxtField.setText(match_game.Questions.get(MatchCnt).GetQuestionA().get(2));
					mtGameRightDTxtField.setText(match_game.Questions.get(MatchCnt).GetQuestionA().get(3));
					
					mtGameLeft1TxtField.setText(match_game.Questions.get(MatchCnt).QuestionB.get(0));
					mtGameLeft2TxtField.setText(match_game.Questions.get(MatchCnt).QuestionB.get(1));
					mtGameLeft3TxtField.setText(match_game.Questions.get(MatchCnt).QuestionB.get(2));
					mtGameLeft4TxtField.setText(match_game.Questions.get(MatchCnt).QuestionB.get(3));
				}
			}
		});
		mtGameBtnShowAns.setEnabled(false);
		mtGameBtnShowAns.setFont(new Font("Chiller", Font.BOLD, 20));
		mtGameBtnShowAns.setBounds(430, 394, 140, 38);
		mtGamePanel.add(mtGameBtnShowAns);
		
		JButton mtGameBtnNextQues = new JButton("Next Question");
		mtGameBtnNextQues.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String a ="",b="",c="",d="";
				Enumeration<AbstractButton> buto = mtGameButtonGroup1.getElements();
				while(buto.hasMoreElements())
				{
					JRadioButton jrd = (JRadioButton) buto.nextElement();
					if(jrd.isSelected()){
						a = jrd.getText();
					}
				}
				Enumeration<AbstractButton> buto1 = mtGameButtonGroup2.getElements();
				while(buto1.hasMoreElements())
				{
					JRadioButton jrd = (JRadioButton) buto1.nextElement();
					if(jrd.isSelected()){
						b = jrd.getText();
					}
				}
				Enumeration<AbstractButton> buto2 = mtGameButtonGroup3.getElements();
				while(buto2.hasMoreElements())
				{
					JRadioButton jrd = (JRadioButton) buto2.nextElement();
					if(jrd.isSelected()){
						c = jrd.getText();
					}
				}
				Enumeration<AbstractButton> buto3 = mtGameButtonGroup4.getElements();
				while(buto3.hasMoreElements())
				{
					JRadioButton jrd = (JRadioButton) buto3.nextElement();
					if(jrd.isSelected()){
						d = jrd.getText();
					}
				}
				int x=a.charAt(0)-65;
				String A=match_game.Questions.get(MatchCnt).QuestionB.get(x);
				x=b.charAt(0)-65;
				String B=match_game.Questions.get(MatchCnt).QuestionB.get(x);
				x=c.charAt(0)-65;
				String C=match_game.Questions.get(MatchCnt).QuestionB.get(x);
				x=d.charAt(0)-65;
				String D=match_game.Questions.get(MatchCnt).QuestionB.get(x);
				
				if((match_game.Questions.get(MatchCnt).AnswerA.get(0).equals(A))&&(match_game.Questions.get(MatchCnt).AnswerA.get(1).equals(B))
						&&((match_game.Questions.get(MatchCnt).AnswerA.get(2).equals(C)))&&((match_game.Questions.get(MatchCnt).AnswerA.get(3).equals(D))))
				{
					JOptionPane.showMessageDialog(null, "Correct Answer");
					MatchCnt++;
					if(MatchCnt==match_game.GetQuestions().size())
					{
						JOptionPane.showMessageDialog(null, "ConGraTulationsssssSSsSSssSss");
						mtGamePanel.setVisible(false);
						playGamePanel.setVisible(true);
					}
					else
					{
						
						mtGameRightATxtField.setText(match_game.Questions.get(MatchCnt).GetQuestionA().get(0));
						mtGameRightBTxtField.setText(match_game.Questions.get(MatchCnt).GetQuestionA().get(1));
						mtGameRightCTxtField.setText(match_game.Questions.get(MatchCnt).GetQuestionA().get(2));
						mtGameRightDTxtField.setText(match_game.Questions.get(MatchCnt).GetQuestionA().get(3));
						
						mtGameLeft1TxtField.setText(match_game.Questions.get(MatchCnt).QuestionB.get(0));
						mtGameLeft2TxtField.setText(match_game.Questions.get(MatchCnt).QuestionB.get(1));
						mtGameLeft3TxtField.setText(match_game.Questions.get(MatchCnt).QuestionB.get(2));
						mtGameLeft4TxtField.setText(match_game.Questions.get(MatchCnt).QuestionB.get(3));
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Wrong Answer");
				}
				
			}
		});
		mtGameBtnNextQues.setEnabled(false);
		mtGameBtnNextQues.setFont(new Font("Chiller", Font.BOLD, 20));
		mtGameBtnNextQues.setBounds(580, 394, 140, 38);
		mtGamePanel.add(mtGameBtnNextQues);
		
		mtGameRightATxtField = new JTextField();
		mtGameRightATxtField.setColumns(10);
		mtGameRightATxtField.setBounds(45, 110, 260, 20);
		mtGamePanel.add(mtGameRightATxtField);
		
		JLabel lblB = new JLabel("B");
		lblB.setFont(new Font("Chiller", Font.BOLD, 20));
		lblB.setBounds(10, 152, 20, 24);
		mtGamePanel.add(lblB);
		
		mtGameRightBTxtField = new JTextField();
		mtGameRightBTxtField.setColumns(10);
		mtGameRightBTxtField.setBounds(45, 155, 260, 20);
		mtGamePanel.add(mtGameRightBTxtField);
		
		JLabel lblC = new JLabel("C");
		lblC.setFont(new Font("Chiller", Font.BOLD, 20));
		lblC.setBounds(364, 107, 20, 24);
		mtGamePanel.add(lblC);
		
		JLabel lblD = new JLabel("D");
		lblD.setFont(new Font("Chiller", Font.BOLD, 20));
		lblD.setBounds(364, 152, 20, 24);
		mtGamePanel.add(lblD);
		
		mtGameRightCTxtField = new JTextField();
		mtGameRightCTxtField.setColumns(10);
		mtGameRightCTxtField.setBounds(394, 110, 260, 20);
		mtGamePanel.add(mtGameRightCTxtField);
		
		mtGameRightDTxtField = new JTextField();
		mtGameRightDTxtField.setColumns(10);
		mtGameRightDTxtField.setBounds(394, 156, 260, 20);
		mtGamePanel.add(mtGameRightDTxtField);
		
		JButton mtGameBtnStartGame = new JButton("Start Game");
		mtGameBtnStartGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MatchCnt=0;
				mtGameBtnStartGame.setEnabled(false);
				mtGameBtnNextQues.setEnabled(true);
				mtGameBtnShowAns.setEnabled(true);
				
				mtGameRightATxtField.setText(match_game.Questions.get(0).GetQuestionA().get(0));
				mtGameRightBTxtField.setText(match_game.Questions.get(0).GetQuestionA().get(1));
				mtGameRightCTxtField.setText(match_game.Questions.get(0).GetQuestionA().get(2));
				mtGameRightDTxtField.setText(match_game.Questions.get(0).GetQuestionA().get(3));
				
				mtGameLeft1TxtField.setText(match_game.Questions.get(0).QuestionB.get(0));
				mtGameLeft2TxtField.setText(match_game.Questions.get(0).QuestionB.get(1));
				mtGameLeft3TxtField.setText(match_game.Questions.get(0).QuestionB.get(2));
				mtGameLeft4TxtField.setText(match_game.Questions.get(0).QuestionB.get(3));
				
			}
		});
		mtGameBtnStartGame.setFont(new Font("Chiller", Font.BOLD, 20));
		mtGameBtnStartGame.setBounds(280, 394, 140, 38);
		mtGamePanel.add(mtGameBtnStartGame);
		
		JButton button_4 = new JButton("Profile");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				if(theAccount.isType())
				{
					mtGamePanel.setVisible(false);
					sProfilePanel.setVisible(true);
				}
				else
				{
					mtGamePanel.setVisible(false);
					tProfilePanel.setVisible(true);
				}
			}
		});
		button_4.setFont(new Font("Chiller", Font.BOLD, 20));
		button_4.setBounds(0, 0, 88, 45);
		mtGamePanel.add(button_4);
		
		JPanel mcqTmpPanel = new JPanel();
		frm_CreategGame.getContentPane().add(mcqTmpPanel, "name_21338434580942");
		mcqTmpPanel.setLayout(null);
		mcqTmpPanel.setVisible(false);
		
		JPanel t_fTmpPanel = new JPanel();
		frm_CreategGame.getContentPane().add(t_fTmpPanel, "name_15292477849874");
		t_fTmpPanel.setLayout(null);
		t_fTmpPanel.setVisible(false);
		
		JPanel mtTmpPanel = new JPanel();
		frm_CreategGame.getContentPane().add(mtTmpPanel, "name_14470309516722");
		mtTmpPanel.setLayout(null);
		mtTmpPanel.setVisible(false);
		
		
		registerNameTxtField = new JTextField();
		registerNameTxtField.setColumns(10);
		registerNameTxtField.setBounds(20, 166, 226, 37);
		registerPanel.add(registerNameTxtField);
		
		registerUserNameTxtField = new JTextField();
		registerUserNameTxtField.setColumns(10);
		registerUserNameTxtField.setBounds(20, 262, 226, 37);
		registerPanel.add(registerUserNameTxtField);
		
		JLabel label_21 = new JLabel("Name");
		label_21.setFont(new Font("Chiller", Font.BOLD, 30));
		label_21.setBounds(20, 97, 106, 58);
		registerPanel.add(label_21);
		
		JLabel label_22 = new JLabel("Username");
		label_22.setFont(new Font("Chiller", Font.BOLD, 30));
		label_22.setBounds(20, 214, 116, 37);
		registerPanel.add(label_22);
		
		JLabel label_23 = new JLabel("Age");
		label_23.setFont(new Font("Chiller", Font.BOLD, 30));
		label_23.setBounds(596, 104, 80, 51);
		registerPanel.add(label_23);
		
		JLabel label_24 = new JLabel("Password");
		label_24.setFont(new Font("Chiller", Font.BOLD, 30));
		label_24.setBounds(595, 207, 129, 51);
		registerPanel.add(label_24);
		
		JLabel label_25 = new JLabel("Email");
		label_25.setFont(new Font("Chiller", Font.BOLD, 30));
		label_25.setBounds(20, 309, 80, 51);
		registerPanel.add(label_25);
		
		JLabel label_26 = new JLabel("Register");
		label_26.setFont(new Font("Chiller", Font.BOLD, 40));
		label_26.setBounds(314, 11, 178, 73);
		registerPanel.add(label_26);
		
		JLabel label_27 = new JLabel("Confirm password");
		label_27.setFont(new Font("Chiller", Font.BOLD, 30));
		label_27.setBounds(596, 309, 226, 51);
		registerPanel.add(label_27);
		
		JFormattedTextField registerAgeformattedTxtField = new JFormattedTextField();
		registerAgeformattedTxtField.setBounds(595, 166, 227, 37);
		registerPanel.add(registerAgeformattedTxtField);
		
		JPanel registerTypeInternalPanel = new JPanel();
		registerTypeInternalPanel.setLayout(null);
		registerTypeInternalPanel.setBorder(new TitledBorder(null, "Type", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		registerTypeInternalPanel.setBounds(314, 166, 185, 100);
		registerPanel.add(registerTypeInternalPanel);
		
		JRadioButton registerRdBtnTeacher = new JRadioButton("Teacher");
		registerTypeButtonGroup.add(registerRdBtnTeacher);
		registerRdBtnTeacher.setBounds(12, 22, 121, 23);
		registerTypeInternalPanel.add(registerRdBtnTeacher);
		
		JRadioButton registerRdBtnStudent = new JRadioButton("Student");
		registerTypeButtonGroup.add(registerRdBtnStudent);
		registerRdBtnStudent.setSelected(true);
		registerRdBtnStudent.setBounds(12, 51, 121, 23);
		registerTypeInternalPanel.add(registerRdBtnStudent);
		
		JButton button = new JButton("Submit");
		button.setFont(new Font("Chiller", Font.BOLD, 30));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String type ="",gender="";
				
				Enumeration<AbstractButton> buto = registerTypeButtonGroup.getElements();
				while(buto.hasMoreElements())
				{
					JRadioButton jrd = (JRadioButton) buto.nextElement();
					if(jrd.isSelected()){
						type = jrd.getText();
					}
				}
				Enumeration<AbstractButton> buto2 = registerGenderButtonGroup.getElements();
				while(buto2.hasMoreElements())
				{
					JRadioButton jrd = (JRadioButton) buto2.nextElement();
					if(jrd.isSelected()){
						gender = jrd.getText();
					}
				}
				//System.out.println(gender + " " + type);
				if(registerEmailTxtField.getText().isEmpty() || registerUserNameTxtField.getText().isEmpty()||registerAgeformattedTxtField.getText().isEmpty()
						||registerPasswordTxtField.getText().isEmpty() || registerConfirmPasswordTxtField.getText().isEmpty()||registerNameTxtField.getText().isEmpty() ){
					JOptionPane.showMessageDialog(null, "Please enter the data needed");
				}else if(!registerPasswordTxtField.getText().equals(registerConfirmPasswordTxtField.getText())){
					JOptionPane.showMessageDialog(null, "The password doesn't match");
				}
				else{
					if(type.equals("Teacher")){
						theAccount = new Teacher();
						theAccount.setType(false);
					}else{
						theAccount = new Student();
						theAccount.setType(true);
					}
					//tmp.setAga();
					theAccount.setName(registerNameTxtField.getText());
					theAccount.setPassword(registerPasswordTxtField.getText());
					theAccount.setUsername(registerUserNameTxtField.getText());
					theAccount.setEmail(registerEmailTxtField.getText());
					theAccount.setGender(gender.charAt(0));
					int t = Integer.parseInt(registerAgeformattedTxtField.getText());
					theAccount.setAga(t);
					if(control.ValidateData(theAccount)){
						if(type.equals("Student"))
						{
							registerNameTxtField.setText("");
							registerPasswordTxtField.setText("");
							registerUserNameTxtField.setText("");
							registerEmailTxtField.setText("");
							registerPanel.setVisible(false);
							sProfilePanel.setVisible(true);
							
						}
						else
						{
							registerNameTxtField.setText("");
							registerPasswordTxtField.setText("");
							registerUserNameTxtField.setText("");
							registerEmailTxtField.setText("");
							registerPanel.setVisible(false);
							tProfilePanel.setVisible(true);
						}
					}else{
						JOptionPane.showMessageDialog(null, "Email is wrong OR Username exits");
						
					}
					
				}
	
			}
		});
		button.setBounds(348, 413, 129, 47);
		registerPanel.add(button);
		
		registerEmailTxtField = new JTextField();
		registerEmailTxtField.setColumns(10);
		registerEmailTxtField.setBounds(20, 371, 226, 37);
		registerPanel.add(registerEmailTxtField);
		
		registerPasswordTxtField = new JPasswordField();
		registerPasswordTxtField.setBounds(596, 270, 226, 37);
		registerPanel.add(registerPasswordTxtField);
		
		registerConfirmPasswordTxtField = new JPasswordField();
		registerConfirmPasswordTxtField.setBounds(596, 371, 226, 37);
		registerPanel.add(registerConfirmPasswordTxtField);
		
		JPanel registerGenderInternalPanel = new JPanel();
		registerGenderInternalPanel.setLayout(null);
		registerGenderInternalPanel.setBorder(new TitledBorder(null, "Gender", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		registerGenderInternalPanel.setBounds(314, 273, 185, 100);
		registerPanel.add(registerGenderInternalPanel);
		
		JRadioButton registerRdBtnMale = new JRadioButton("M");
		registerGenderButtonGroup.add(registerRdBtnMale);
		registerRdBtnMale.setSelected(true);
		registerRdBtnMale.setBounds(6, 19, 109, 23);
		registerGenderInternalPanel.add(registerRdBtnMale);
		
		JRadioButton registerRdBtnFemale = new JRadioButton("F");
		registerGenderButtonGroup.add(registerRdBtnFemale);
		registerRdBtnFemale.setBounds(6, 48, 109, 23);
		registerGenderInternalPanel.add(registerRdBtnFemale);
		
		
		
		JButton loginBtnLogin = new JButton("Login");
		loginBtnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(control.VallidLogin(loginUsernameTxtField.getText(), loginPasswordTxtField.getText())){
					if(control.CheckType(loginUsernameTxtField.getText())){
						theAccount = control.getAccount(loginUsernameTxtField.getText());
						loginPanel.setVisible(false);
						sProfilePanel.setVisible(true);
					}else{
						theAccount = control.getAccount(loginUsernameTxtField.getText());
						loginPanel.setVisible(false);
						tProfilePanel.setVisible(true);
					}
				}else{
					JOptionPane.showMessageDialog(null, "Wrong Username or Password ");
				}
			}
		});
		loginBtnLogin.setFont(new Font("Chiller", Font.BOLD, 40));
		loginBtnLogin.setBounds(309, 317, 186, 69);
		loginPanel.add(loginBtnLogin);
		
		loginPasswordTxtField = new JPasswordField();
		loginPasswordTxtField.setFont(new Font("Chiller", Font.PLAIN, 18));
		loginPasswordTxtField.setBounds(189, 233, 201, 31);
		loginPanel.add(loginPasswordTxtField);
		
		JLabel label_19 = new JLabel("Password :");
		label_19.setFont(new Font("Chiller", Font.BOLD, 30));
		label_19.setBounds(31, 223, 148, 54);
		loginPanel.add(label_19);
		
		JLabel label_20 = new JLabel("Username :");
		label_20.setFont(new Font("Chiller", Font.BOLD, 30));
		label_20.setBounds(31, 112, 148, 44);
		loginPanel.add(label_20);
		
		loginUsernameTxtField = new JTextField();
		loginUsernameTxtField.setFont(new Font("Chiller", Font.PLAIN, 18));
		loginUsernameTxtField.setColumns(10);
		loginUsernameTxtField.setBounds(189, 112, 201, 31);
		loginPanel.add(loginUsernameTxtField);
		
		JButton btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				loginPanel.setVisible(false);
				homePanel.setVisible(true);
			}
		});
		btnHome.setFont(new Font("Chiller", Font.BOLD, 20));
		btnHome.setBounds(0, 0, 88, 45);
		loginPanel.add(btnHome);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Chiller", Font.BOLD, 40));
		lblLogin.setBounds(332, 0, 79, 77);
		loginPanel.add(lblLogin);
		
		
		
		
		
		JButton sProfileBtnPlayGame = new JButton("Play Game");
		sProfileBtnPlayGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sProfilePanel.setVisible(false);
				playGamePanel.setVisible(true);
			}
		});
		sProfileBtnPlayGame.setFont(new Font("Chiller", Font.BOLD, 40));
		sProfileBtnPlayGame.setBounds(224, 237, 305, 61);
		sProfilePanel.add(sProfileBtnPlayGame);
		
		JLabel label_28 = new JLabel("Student Profile");
		label_28.setFont(new Font("Chiller", Font.BOLD, 40));
		label_28.setBounds(272, 75, 215, 61);
		sProfilePanel.add(label_28);
		
		JButton sProfileBtnLogout = new JButton("Log Out");
		sProfileBtnLogout.setFont(new Font("Chiller", Font.BOLD, 18));
		sProfileBtnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				theAccount = new Account();
				sProfilePanel.setVisible(false);
				homePanel.setVisible(true);
				
			}
		});
		sProfileBtnLogout.setBounds(0, 0, 104, 34);
		sProfilePanel.add(sProfileBtnLogout);
		
		
		
		
		
		JButton tProfileBtnPlayGame = new JButton("Play Game");
		tProfileBtnPlayGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tProfilePanel.setVisible(false);
				playGamePanel.setVisible(true);
			}
		});
		tProfileBtnPlayGame.setFont(new Font("Chiller", Font.BOLD, 40));
		tProfileBtnPlayGame.setBounds(222, 311, 305, 61);
		tProfilePanel.add(tProfileBtnPlayGame);
		
		JButton tProfileBtnAddGame = new JButton("Add Game");
		tProfileBtnAddGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tProfilePanel.setVisible(false);
				createGamePanel.setVisible(true);
			}
		});
		tProfileBtnAddGame.setFont(new Font("Chiller", Font.BOLD, 40));
		tProfileBtnAddGame.setBounds(222, 190, 305, 61);
		tProfilePanel.add(tProfileBtnAddGame);
		
		JLabel label_29 = new JLabel("Teacher Profile");
		label_29.setFont(new Font("Chiller", Font.BOLD, 40));
		label_29.setBounds(270, 62, 215, 61);
		tProfilePanel.add(label_29);
		
		JButton tProfileBtnLogout = new JButton("Log Out");
		tProfileBtnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				theAccount = new Account();
				tProfilePanel.setVisible(false);
				homePanel.setVisible(true);
			}
		});
		tProfileBtnLogout.setFont(new Font("Chiller", Font.BOLD, 18));
		tProfileBtnLogout.setBounds(0, 0, 104, 34);
		tProfilePanel.add(tProfileBtnLogout);
		
		
		
		JLabel lblNewLabel_7 = new JLabel("Game Subject");
		lblNewLabel_7.setBounds(10, 178, 142, 36);
		lblNewLabel_7.setFont(new Font("Chiller", Font.BOLD, 30));
		createGamePanel.add(lblNewLabel_7);
		
		JPanel createGameGameTypeInternalPanel = new JPanel();
		createGameGameTypeInternalPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Game Type", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		createGameGameTypeInternalPanel.setBounds(13, 234, 599, 117);
		createGamePanel.add(createGameGameTypeInternalPanel);
		createGameGameTypeInternalPanel.setLayout(null);
		
		
		JRadioButton createGameRdBtnMcq = new JRadioButton("MCQ");
		createGameRdBtnMcq.setSelected(true);
		createGameGameTypebuttonGroup.add(createGameRdBtnMcq);
		createGameRdBtnMcq.setBounds(20, 36, 111, 25);
		createGameGameTypeInternalPanel.add(createGameRdBtnMcq);
		
		JRadioButton createGameRdBtnMatch = new JRadioButton("Match");
		createGameGameTypebuttonGroup.add(createGameRdBtnMatch);
		createGameRdBtnMatch.setBounds(20, 64, 111, 25);
		createGameGameTypeInternalPanel.add(createGameRdBtnMatch);
		
		JRadioButton createGameRdBtnT_F = new JRadioButton("T/F");
		createGameGameTypebuttonGroup.add(createGameRdBtnT_F);
		createGameRdBtnT_F.setBounds(20, 87, 111, 25);
		createGameGameTypeInternalPanel.add(createGameRdBtnT_F);
		
		JButton createGameBtnCreateGame = new JButton("Create Game");
		createGameBtnCreateGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String type ="";
				Enumeration<AbstractButton> buto = createGameGameTypebuttonGroup.getElements();
				while(buto.hasMoreElements())
				{
					JRadioButton jrd = (JRadioButton) buto.nextElement();
					if(jrd.isSelected()){
						type = jrd.getText();
					}
				}
				if( createGameGameSubjectTxtField.getText().isEmpty() || createGameGameNameTxtField.getText().isEmpty()  )
				{
					JOptionPane.showMessageDialog(null, "Please enter all the data");
					return;
				}
				if(control.checkGameName(createGameGameNameTxtField.getText())){
					JOptionPane.showMessageDialog(null, "Name already exits");
					return;
				}
				
				Subject = createGameGameSubjectTxtField.getText();
				Name = createGameGameNameTxtField.getText();
				createGameGameSubjectTxtField.setText("");
				createGameGameNameTxtField.setText("");
				if(type.equals("MCQ"))
				{
					mcqTmpPanel.setVisible(true);
					createGamePanel.setVisible(false);
				}
				else if(type.equals("Match"))
				{
					mtTmpPanel.setVisible(true);
					createGamePanel.setVisible(false);
				}
				else if(type.equals("T/F"))
				{
					t_fTmpPanel.setVisible(true);
					createGamePanel.setVisible(false);
				}
				
				
			}
		});
		createGameBtnCreateGame.setFont(new Font("Chiller", Font.BOLD, 30));
		createGameBtnCreateGame.setBounds(617, 371, 170, 57);
		createGamePanel.add(createGameBtnCreateGame);
		
		JLabel lblNewLabel_8 = new JLabel("Create Game");
		lblNewLabel_8.setFont(new Font("Chiller", Font.BOLD, 40));
		lblNewLabel_8.setBounds(279, 11, 192, 77);
		createGamePanel.add(lblNewLabel_8);
		
		JLabel lblGameName = new JLabel("Game Name");
		lblGameName.setFont(new Font("Chiller", Font.BOLD, 30));
		lblGameName.setBounds(10, 110, 142, 36);
		createGamePanel.add(lblGameName);
		
		createGameGameNameTxtField = new JTextField();
		createGameGameNameTxtField.setColumns(10);
		createGameGameNameTxtField.setBounds(183, 119, 424, 27);
		createGamePanel.add(createGameGameNameTxtField);
		
		createGameGameSubjectTxtField = new JTextField();
		createGameGameSubjectTxtField.setColumns(10);
		createGameGameSubjectTxtField.setBounds(183, 187, 424, 27);
		createGamePanel.add(createGameGameSubjectTxtField);
		
		JButton btnProfile = new JButton("Profile");
		btnProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(theAccount.isType())
				{
					createGamePanel.setVisible(false);
					sProfilePanel.setVisible(true);
				}
				else
				{
					createGamePanel.setVisible(false);
					tProfilePanel.setVisible(true);
				}
				
			}
		});
		btnProfile.setFont(new Font("Chiller", Font.BOLD, 20));
		btnProfile.setBounds(0, 0, 88, 45);
		createGamePanel.add(btnProfile);
		
		
		
		
		
		JLabel label_33 = new JLabel("T or F Game");
		label_33.setFont(new Font("Chiller", Font.BOLD, 40));
		label_33.setBounds(299, 11, 187, 61);
		t_fGamePanel.add(label_33);
		
		JLabel label_34 = new JLabel("Question");
		label_34.setFont(new Font("Chiller", Font.BOLD, 40));
		label_34.setBounds(10, 102, 131, 47);
		t_fGamePanel.add(label_34);
		
		t_fGameQuesTxtField = new JTextField();
		t_fGameQuesTxtField.setFont(new Font("Arial", Font.PLAIN, 20));
		t_fGameQuesTxtField.setColumns(10);
		t_fGameQuesTxtField.setBounds(169, 102, 586, 44);
		t_fGamePanel.add(t_fGameQuesTxtField);
		
		JPanel t_fGameChoicesInternalPanel = new JPanel();
		t_fGameChoicesInternalPanel.setLayout(null);
		t_fGameChoicesInternalPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "True or False", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		t_fGameChoicesInternalPanel.setBounds(10, 180, 745, 118);
		t_fGamePanel.add(t_fGameChoicesInternalPanel);
		
		JRadioButton t_fGameRdBtnTrue = new JRadioButton("True");
		t_fGameButtonGroup.add(t_fGameRdBtnTrue);
		t_fGameRdBtnTrue.setSelected(true);
		t_fGameRdBtnTrue.setBounds(6, 36, 227, 23);
		t_fGameChoicesInternalPanel.add(t_fGameRdBtnTrue);
		
		JRadioButton t_fGameRdBtnFalse = new JRadioButton("False");
		t_fGameButtonGroup.add(t_fGameRdBtnFalse);
		t_fGameRdBtnFalse.setBounds(6, 72, 227, 23);
		t_fGameChoicesInternalPanel.add(t_fGameRdBtnFalse);
		
		JButton t_fGameBtnSubmitAns = new JButton("Submit Answer");
		t_fGameBtnSubmitAns.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					String type ="";
					Enumeration<AbstractButton> buto = t_fGameButtonGroup.getElements();
					while(buto.hasMoreElements())
					{
						JRadioButton jrd = (JRadioButton) buto.nextElement();
						if(jrd.isSelected()){
							type = jrd.getText();
						}
					}
					String ans = tfGame.Questions.get(T_FCnt).GetAnswer();
					if(type.equals(ans)){
						JOptionPane.showMessageDialog(null, "Correct Answer");
				
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Wrong Answer");	
					}
					T_FCnt++;
					if(T_FCnt==tfGame.Questions.size())
					{
						JOptionPane.showMessageDialog(null, "Congratulation");
						t_fGamePanel.setVisible(false);
						playGamePanel.setVisible(true);
					}
					t_fGameQuesTxtField.setText(tfGame.Questions.get(T_FCnt).GetQuestion());
				

		
			}
		});
		t_fGameBtnSubmitAns.setEnabled(false);
		t_fGameBtnSubmitAns.setFont(new Font("Chiller", Font.BOLD, 20));
		t_fGameBtnSubmitAns.setBounds(615, 309, 140, 38);
		t_fGamePanel.add(t_fGameBtnSubmitAns);
		
		JButton t_fGameBtnShowAns = new JButton("Show Answer");
		t_fGameBtnShowAns.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, tfGame.Questions.get(T_FCnt).GetAnswer());
				T_FCnt++;
				if(T_FCnt==tfGame.Questions.size())
				{
					JOptionPane.showMessageDialog(null, "Congratulation");
					t_fGamePanel.setVisible(false);
					playGamePanel.setVisible(true);
				}
				t_fGameQuesTxtField.setText(tfGame.Questions.get(T_FCnt).GetQuestion());
			}
		});
		t_fGameBtnShowAns.setEnabled(false);
		t_fGameBtnShowAns.setFont(new Font("Chiller", Font.BOLD, 20));
		t_fGameBtnShowAns.setBounds(465, 309, 140, 38);
		t_fGamePanel.add(t_fGameBtnShowAns);
		
		JButton t_fGameBtnStartGame = new JButton("Start Game");
		t_fGameBtnStartGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				T_FCnt=0;
				t_fGameBtnStartGame.setEnabled(false);
				t_fGameQuesTxtField.setText(tfGame.Questions.get(0).GetQuestion());
				t_fGameBtnShowAns.setEnabled(true);
				t_fGameBtnSubmitAns.setEnabled(true);
			}
			
		});
		t_fGameBtnStartGame.setFont(new Font("Chiller", Font.BOLD, 20));
		t_fGameBtnStartGame.setBounds(315, 309, 140, 38);
		t_fGamePanel.add(t_fGameBtnStartGame);
		
		JButton button_3 = new JButton("Profile");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(theAccount.isType())
				{
					t_fGamePanel.setVisible(false);
					sProfilePanel.setVisible(true);
				}
				else
				{
					t_fGamePanel.setVisible(false);
					tProfilePanel.setVisible(true);
				}
			}
		});
		button_3.setFont(new Font("Chiller", Font.BOLD, 20));
		button_3.setBounds(0, 0, 88, 45);
		t_fGamePanel.add(button_3);
		
		
		

		
		JLabel label_16 = new JLabel("T or F Questions Template");
		label_16.setFont(new Font("Chiller", Font.BOLD, 40));
		label_16.setBounds(222, 54, 369, 61);
		t_fTmpPanel.add(label_16);
		
		JLabel label_17 = new JLabel("Question");
		label_17.setFont(new Font("Chiller", Font.BOLD, 40));
		label_17.setBounds(50, 194, 131, 47);
		t_fTmpPanel.add(label_17);
		
		t_fTmpQuesTxtField = new JTextField();
		t_fTmpQuesTxtField.setColumns(10);
		t_fTmpQuesTxtField.setBounds(273, 194, 459, 44);
		t_fTmpPanel.add(t_fTmpQuesTxtField);
		
		JLabel label_18 = new JLabel("Correct Answer");
		label_18.setFont(new Font("Chiller", Font.BOLD, 40));
		label_18.setBounds(48, 288, 213, 37);
		t_fTmpPanel.add(label_18);
		
		t_fTmpAnsTxtField = new JTextField();
		t_fTmpAnsTxtField.setColumns(10);
		t_fTmpAnsTxtField.setBounds(273, 281, 459, 44);
		t_fTmpPanel.add(t_fTmpAnsTxtField);
		
		t_fTmpBtnAddQ = new JButton("Add Question");
		t_fTmpBtnAddQ.addActionListener(t_fTmpBtnAddQActionListener);
		t_fTmpBtnAddQ.setFont(new Font("Chiller", Font.BOLD, 30));
		t_fTmpBtnAddQ.setBounds(308, 395, 181, 38);
		t_fTmpPanel.add(t_fTmpBtnAddQ);
		
		JButton t_fTmpBtnAddQSubmit = new JButton("Submit Game");
		t_fTmpBtnAddQSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tfGame.setName(Name);
				tfGame.setSubject(Subject);
				control.AddGame(tfGame);
				//Vector<Game> tmp = control.GetAllGame(0, Subject);
				t_fTmpPanel.setVisible(false);
				tProfilePanel.setVisible(true);
			}
		});
		t_fTmpBtnAddQSubmit.setFont(new Font("Chiller", Font.BOLD, 30));
		t_fTmpBtnAddQSubmit.setBounds(516, 395, 182, 38);
		t_fTmpPanel.add(t_fTmpBtnAddQSubmit);
		
		JButton button_6 = new JButton("Profile");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(theAccount.isType())
				{
					t_fTmpPanel.setVisible(false);
					sProfilePanel.setVisible(true);
				}
				else
				{
					t_fTmpPanel.setVisible(false);
					tProfilePanel.setVisible(true);
				}
			}
		});
		button_6.setFont(new Font("Chiller", Font.BOLD, 20));
		button_6.setBounds(0, 0, 88, 45);
		t_fTmpPanel.add(button_6);
		
		
		
		
		
		mcqTmpQuesTxtField = new JTextField();
		mcqTmpQuesTxtField.setBounds(141, 114, 436, 32);
		mcqTmpPanel.add(mcqTmpQuesTxtField);
		mcqTmpQuesTxtField.setColumns(10);
		
		mcqTmpCho1TxtField = new JTextField();
		mcqTmpCho1TxtField.setBounds(141, 191, 250, 20);
		mcqTmpPanel.add(mcqTmpCho1TxtField);
		mcqTmpCho1TxtField.setColumns(10);
		
		mcqTmpCho2TxtField = new JTextField();
		mcqTmpCho2TxtField.setBounds(544, 191, 250, 20);
		mcqTmpPanel.add(mcqTmpCho2TxtField);
		mcqTmpCho2TxtField.setColumns(10);
		
		mcqTmpCho3TxtField = new JTextField();
		mcqTmpCho3TxtField.setBounds(141, 256, 250, 20);
		mcqTmpPanel.add(mcqTmpCho3TxtField);
		mcqTmpCho3TxtField.setColumns(10);
		
		mcqTmpCho4TxtField = new JTextField();
		mcqTmpCho4TxtField.setBounds(544, 256, 250, 20);
		mcqTmpPanel.add(mcqTmpCho4TxtField);
		mcqTmpCho4TxtField.setColumns(10);
		
		mcqTmpAnsTxtField = new JTextField();
		mcqTmpAnsTxtField.setBounds(255, 337, 279, 38);
		mcqTmpPanel.add(mcqTmpAnsTxtField);
		mcqTmpAnsTxtField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Question");
		lblNewLabel.setBounds(10, 114, 109, 32);
		mcqTmpPanel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Chiller", Font.BOLD, 30));
		
		JLabel lblNewLabel_1 = new JLabel("Choice 1");
		lblNewLabel_1.setBounds(10, 177, 109, 42);
		mcqTmpPanel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Chiller", Font.BOLD, 25));
		
		JLabel lblNewLabel_2 = new JLabel("Choice 2");
		lblNewLabel_2.setBounds(425, 177, 109, 42);
		mcqTmpPanel.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Chiller", Font.BOLD, 25));
		
		JLabel lblNewLabel_3 = new JLabel("Choice 3");
		lblNewLabel_3.setBounds(10, 247, 109, 32);
		mcqTmpPanel.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Chiller", Font.BOLD, 25));
		
		JLabel lblNewLabel_4 = new JLabel("Choice 4");
		lblNewLabel_4.setBounds(425, 247, 109, 32);
		mcqTmpPanel.add(lblNewLabel_4);
		lblNewLabel_4.setFont(new Font("Chiller", Font.BOLD, 25));
		
		JLabel lblNewLabel_5 = new JLabel("Correct Answer");
		lblNewLabel_5.setBounds(10, 330, 279, 38);
		mcqTmpPanel.add(lblNewLabel_5);
		lblNewLabel_5.setFont(new Font("Chiller", Font.BOLD, 40));
		
		JLabel lblNewLabel_6 = new JLabel("MCQ Questions Template");
		lblNewLabel_6.setBounds(220, 7, 357, 80);
		mcqTmpPanel.add(lblNewLabel_6);
		lblNewLabel_6.setFont(new Font("Chiller", Font.BOLD, 40));
		
		JButton mcqTmpBtnAddQ = new JButton("Add Question");
		mcqTmpBtnAddQ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] choc = new String[4];
				String qq = mcqTmpQuesTxtField.getText();
				choc[0] = mcqTmpCho1TxtField.getText();
				choc[1] = mcqTmpCho2TxtField.getText();
				choc[2] = mcqTmpCho3TxtField.getText();
				choc[3] = mcqTmpCho4TxtField.getText();
				String aa = mcqTmpAnsTxtField.getText();
				MCQ_Question q = new MCQ_Question(qq, aa, choc);
				if(mcqTmpQuesTxtField.getText().isEmpty() || mcqTmpCho1TxtField.getText().isEmpty()||
						mcqTmpCho2TxtField.getText().isEmpty()||mcqTmpCho3TxtField.getText().isEmpty()||
						mcqTmpCho4TxtField.getText().isEmpty()||mcqTmpAnsTxtField.getText().isEmpty()
					){
					
				}
					
				
				McQ_Game.AddQuestion(q);
				mcqTmpQuesTxtField.setText("");
				mcqTmpCho1TxtField.setText("");
				mcqTmpCho2TxtField.setText("");
				mcqTmpCho3TxtField.setText("");
				mcqTmpCho4TxtField.setText("");
				mcqTmpAnsTxtField.setText("");
			}
		});
		mcqTmpBtnAddQ.setFont(new Font("Chiller", Font.BOLD, 30));
		mcqTmpBtnAddQ.setBounds(612, 337, 182, 38);
		mcqTmpPanel.add(mcqTmpBtnAddQ);
		
		JButton mcqTmpBtnSubmit = new JButton("Submit Game");
		mcqTmpBtnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				McQ_Game.setSubject(Subject);
				McQ_Game.setName(Name);
				control.AddGame(McQ_Game);
				mcqTmpPanel.setVisible(false);
				tProfilePanel.setVisible(true);
				
			}
		});
		mcqTmpBtnSubmit.setFont(new Font("Chiller", Font.BOLD, 30));
		mcqTmpBtnSubmit.setBounds(612, 386, 182, 38);
		mcqTmpPanel.add(mcqTmpBtnSubmit);
		
		JButton button_5 = new JButton("Profile");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				if(theAccount.isType())
				{
					mcqTmpPanel.setVisible(false);
					sProfilePanel.setVisible(true);
				}
				else
				{
					mcqTmpPanel.setVisible(false);
					tProfilePanel.setVisible(true);
				}
				
			}
		});
		button_5.setFont(new Font("Chiller", Font.BOLD, 20));
		button_5.setBounds(0, 0, 88, 45);
		mcqTmpPanel.add(button_5);
		
		
		
		JLabel label = new JLabel("Matching Questions Template");
		label.setFont(new Font("Chiller", Font.BOLD, 40));
		label.setBounds(177, 11, 418, 61);
		mtTmpPanel.add(label);
		
		JLabel label_1 = new JLabel("left");
		label_1.setFont(new Font("Chiller", Font.BOLD, 30));
		label_1.setBounds(20, 83, 63, 36);
		mtTmpPanel.add(label_1);
		
		JLabel label_2 = new JLabel("1");
		label_2.setFont(new Font("Chiller", Font.BOLD, 20));
		label_2.setBounds(20, 129, 27, 20);
		mtTmpPanel.add(label_2);
		
		JLabel label_3 = new JLabel("2");
		label_3.setFont(new Font("Chiller", Font.BOLD, 20));
		label_3.setBounds(18, 164, 27, 20);
		mtTmpPanel.add(label_3);
		
		JLabel label_4 = new JLabel("3");
		label_4.setFont(new Font("Chiller", Font.BOLD, 20));
		label_4.setBounds(18, 195, 27, 20);
		mtTmpPanel.add(label_4);
		
		JLabel label_5 = new JLabel("4");
		label_5.setFont(new Font("Chiller", Font.BOLD, 20));
		label_5.setBounds(18, 226, 27, 20);
		mtTmpPanel.add(label_5);
		
		mtTmpLefttxtfield1 = new JTextField();
		mtTmpLefttxtfield1.setColumns(10);
		mtTmpLefttxtfield1.setBounds(55, 130, 183, 20);
		mtTmpPanel.add(mtTmpLefttxtfield1);
		
		mtTmpLefttxtfield2 = new JTextField();
		mtTmpLefttxtfield2.setColumns(10);
		mtTmpLefttxtfield2.setBounds(55, 161, 183, 20);
		mtTmpPanel.add(mtTmpLefttxtfield2);
		
		mtTmpLefttxtfield3 = new JTextField();
		mtTmpLefttxtfield3.setColumns(10);
		mtTmpLefttxtfield3.setBounds(55, 192, 183, 20);
		mtTmpPanel.add(mtTmpLefttxtfield3);
		
		mtTmpLefttxtfield4 = new JTextField();
		mtTmpLefttxtfield4.setColumns(10);
		mtTmpLefttxtfield4.setBounds(55, 223, 183, 20);
		mtTmpPanel.add(mtTmpLefttxtfield4);
		
		JLabel label_6 = new JLabel("Right");
		label_6.setFont(new Font("Chiller", Font.BOLD, 30));
		label_6.setBounds(309, 83, 63, 36);
		mtTmpPanel.add(label_6);
		
		JLabel label_12 = new JLabel("A");
		label_12.setFont(new Font("Chiller", Font.BOLD, 20));
		label_12.setBounds(309, 130, 27, 20);
		mtTmpPanel.add(label_12);
		
		JLabel label_13 = new JLabel("B");
		label_13.setFont(new Font("Chiller", Font.BOLD, 20));
		label_13.setBounds(309, 161, 27, 20);
		mtTmpPanel.add(label_13);
		
		JLabel label_14 = new JLabel("C");
		label_14.setFont(new Font("Chiller", Font.BOLD, 20));
		label_14.setBounds(309, 192, 27, 20);
		mtTmpPanel.add(label_14);
		
		JLabel label_15 = new JLabel("D");
		label_15.setFont(new Font("Chiller", Font.BOLD, 20));
		label_15.setBounds(309, 223, 27, 20);
		mtTmpPanel.add(label_15);
		
		mtTmpLefttxtfieldA = new JTextField();
		mtTmpLefttxtfieldA.setColumns(10);
		mtTmpLefttxtfieldA.setBounds(346, 130, 183, 20);
		mtTmpPanel.add(mtTmpLefttxtfieldA);
		
		mtTmpLefttxtfieldB = new JTextField();
		mtTmpLefttxtfieldB.setColumns(10);
		mtTmpLefttxtfieldB.setBounds(346, 161, 183, 20);
		mtTmpPanel.add(mtTmpLefttxtfieldB);
		
		mtTmpLefttxtfieldC = new JTextField();
		mtTmpLefttxtfieldC.setColumns(10);
		mtTmpLefttxtfieldC.setBounds(346, 192, 183, 20);
		mtTmpPanel.add(mtTmpLefttxtfieldC);
		
		mtTmpLefttxtfieldD = new JTextField();
		mtTmpLefttxtfieldD.setColumns(10);
		mtTmpLefttxtfieldD.setBounds(346, 223, 183, 20);
		mtTmpPanel.add(mtTmpLefttxtfieldD);
		
		JLabel label_7 = new JLabel("Answers");
		label_7.setFont(new Font("Chiller", Font.BOLD, 30));
		label_7.setBounds(10, 282, 83, 36);
		mtTmpPanel.add(label_7);
		
		JLabel label_8 = new JLabel("1");
		label_8.setFont(new Font("Chiller", Font.BOLD, 20));
		label_8.setBounds(10, 345, 27, 20);
		mtTmpPanel.add(label_8);
		
		mtTmpAns1 = new JTextField();
		mtTmpAns1.setColumns(10);
		mtTmpAns1.setBounds(55, 346, 38, 21);
		mtTmpPanel.add(mtTmpAns1);
		
		JLabel label_9 = new JLabel("2");
		label_9.setFont(new Font("Chiller", Font.BOLD, 20));
		label_9.setBounds(140, 343, 27, 20);
		mtTmpPanel.add(label_9);
		
		mtTmpAns2 = new JTextField();
		mtTmpAns2.setColumns(10);
		mtTmpAns2.setBounds(184, 346, 38, 21);
		mtTmpPanel.add(mtTmpAns2);
		
		JLabel label_10 = new JLabel("3");
		label_10.setFont(new Font("Chiller", Font.BOLD, 20));
		label_10.setBounds(268, 343, 27, 20);
		mtTmpPanel.add(label_10);
		
		mtTmpAns3 = new JTextField();
		mtTmpAns3.setColumns(10);
		mtTmpAns3.setBounds(309, 344, 38, 21);
		mtTmpPanel.add(mtTmpAns3);
		
		JLabel label_11 = new JLabel("4");
		label_11.setFont(new Font("Chiller", Font.BOLD, 20));
		label_11.setBounds(398, 345, 27, 20);
		mtTmpPanel.add(label_11);
		
		mtTmpAns4 = new JTextField();
		mtTmpAns4.setColumns(10);
		mtTmpAns4.setBounds(435, 346, 38, 21);
		mtTmpPanel.add(mtTmpAns4);
		
		JButton mtTmpBtnAddQuestion = new JButton("Add Question");
		mtTmpBtnAddQuestion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				if( mtTmpLefttxtfield1.getText().isEmpty() || mtTmpLefttxtfield2.getText().isEmpty() ||
						mtTmpLefttxtfield3.getText().isEmpty()  || mtTmpLefttxtfield4.getText().isEmpty()
						|| mtTmpLefttxtfieldA.getText().isEmpty() || mtTmpLefttxtfieldB.getText().isEmpty()||
						mtTmpLefttxtfieldC.getText().isEmpty() || mtTmpLefttxtfieldD.getText().isEmpty() 
						|| mtTmpAns1.getText().isEmpty() || mtTmpAns2.getText().isEmpty()||
						mtTmpAns3.getText().isEmpty() || mtTmpAns4.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Please enter all the data");
					return;
				}
				else
				{
					MatchQuestion mtQu = new MatchQuestion();
					mtQu.QuestionA.addElement(mtTmpLefttxtfield1.getText());
					mtQu.QuestionA.addElement(mtTmpLefttxtfield2.getText());
					mtQu.QuestionA.addElement(mtTmpLefttxtfield3.getText());
					mtQu.QuestionA.addElement(mtTmpLefttxtfield4.getText());
					
					mtQu.QuestionB.addElement(mtTmpLefttxtfieldA.getText());
					mtQu.QuestionB.addElement(mtTmpLefttxtfieldB.getText());
					mtQu.QuestionB.addElement(mtTmpLefttxtfieldC.getText());
					mtQu.QuestionB.addElement(mtTmpLefttxtfieldD.getText());
					
					mtQu.AnswerA.addElement(mtQu.getStr( mtTmpAns1.getText().charAt(0)) );
					mtQu.AnswerA.addElement(mtQu.getStr( mtTmpAns2.getText().charAt(0)) );
					mtQu.AnswerA.addElement(mtQu.getStr( mtTmpAns3.getText().charAt(0)) );
					mtQu.AnswerA.addElement(mtQu.getStr( mtTmpAns4.getText().charAt(0)) );
					
					match_game.AddQuestion(mtQu);
					mtTmpLefttxtfield1.setText("");
					mtTmpLefttxtfield2.setText("");
					mtTmpLefttxtfield3.setText("");
					mtTmpLefttxtfield4.setText("");
					
					mtTmpLefttxtfieldA.setText("");
					mtTmpLefttxtfieldB.setText("");
					mtTmpLefttxtfieldC.setText("");
					mtTmpLefttxtfieldD.setText("");
					
					mtTmpAns1.setText("");
					mtTmpAns2.setText("");
					mtTmpAns3.setText("");
					mtTmpAns4.setText("");
					
					
				}
			}});
		mtTmpBtnAddQuestion.setFont(new Font("Chiller", Font.BOLD, 30));
		mtTmpBtnAddQuestion.setBounds(559, 335, 182, 35);
		mtTmpPanel.add(mtTmpBtnAddQuestion);
		
		JButton mtTmpBtnSubmit = new JButton("Submit Game");
		mtTmpBtnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				match_game.setName(Name);
				match_game.setSubject(Subject);
				control.AddGame(match_game);
				//System.out.println(match_game);
				mtTmpPanel.setVisible(false);
				tProfilePanel.setVisible(true);
			}
		});
		mtTmpBtnSubmit.setFont(new Font("Chiller", Font.BOLD, 30));
		mtTmpBtnSubmit.setBounds(559, 393, 182, 35);
		mtTmpPanel.add(mtTmpBtnSubmit);
		
		JButton button_7 = new JButton("Profile");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				if(theAccount.isType())
				{
					mtTmpPanel.setVisible(false);
					sProfilePanel.setVisible(true);
				}
				else
				{
					mtTmpPanel.setVisible(false);
					tProfilePanel.setVisible(true);
				}
				
			}
		});
		button_7.setFont(new Font("Chiller", Font.BOLD, 20));
		button_7.setBounds(0, 0, 88, 45);
		mtTmpPanel.add(button_7);
		
		
		
		JLabel label_30 = new JLabel("Clever Zone");
		label_30.setForeground(Color.BLACK);
		label_30.setFont(new Font("Chiller", Font.BOLD, 76));
		label_30.setBackground(Color.WHITE);
		label_30.setBounds(275, 162, 363, 149);
		homePanel.add(label_30);
		
		JButton homeBtnLogIn = new JButton("Login");
		homeBtnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				homePanel.setVisible(false);
				loginPanel.setVisible(true);
			}
		});
		homeBtnLogIn.setForeground(Color.BLACK);
		homeBtnLogIn.setFont(new Font("Chiller", Font.BOLD, 40));
		homeBtnLogIn.setContentAreaFilled(false);
		homeBtnLogIn.setBorderPainted(false);
		homeBtnLogIn.setBackground(Color.WHITE);
		homeBtnLogIn.setBounds(680, 110, 150, 65);
		homePanel.add(homeBtnLogIn);
		
		JButton homeBtnStudentRegister = new JButton("Register");
		homeBtnStudentRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				homePanel.setVisible(false);
				registerPanel.setVisible(true);
				
			}
		});
		homeBtnStudentRegister.setOpaque(false);
		homeBtnStudentRegister.setForeground(Color.BLACK);
		homeBtnStudentRegister.setFont(new Font("Chiller", Font.BOLD, 40));
		homeBtnStudentRegister.setContentAreaFilled(false);
		homeBtnStudentRegister.setBorderPainted(false);
		homeBtnStudentRegister.setBackground(Color.WHITE);
		homeBtnStudentRegister.setBounds(680, 200, 150, 65);
		homePanel.add(homeBtnStudentRegister);
		
		
		
		JLabel label_31 = new JLabel("MCQ Game");
		label_31.setFont(new Font("Chiller", Font.BOLD, 40));
		label_31.setBounds(300, 11, 163, 61);
		mcqGamePanel.add(label_31);
		
		JLabel label_32 = new JLabel("Question");
		label_32.setFont(new Font("Chiller", Font.BOLD, 30));
		label_32.setBounds(10, 96, 99, 27);
		mcqGamePanel.add(label_32);
		
		mcqGameQuesTxtField = new JTextField();
		mcqGameQuesTxtField.setFont(new Font("Arial", Font.PLAIN, 15));
		mcqGameQuesTxtField.setColumns(10);
		mcqGameQuesTxtField.setBounds(119, 96, 632, 27);
		mcqGamePanel.add(mcqGameQuesTxtField);
		
		JPanel mcqGameChoicesInternalPanel = new JPanel();
		mcqGameChoicesInternalPanel.setBorder(new TitledBorder(null, "Choices", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		mcqGameChoicesInternalPanel.setBounds(10, 154, 745, 188);
		mcqGamePanel.add(mcqGameChoicesInternalPanel);
		mcqGameChoicesInternalPanel.setLayout(null);
		
		JRadioButton mcqGameRdBtnChoice1 = new JRadioButton("Choice 1");
		mcqGameRdBtnChoice1.setSelected(true);
		mcqGameChoicesButtonGroup.add(mcqGameRdBtnChoice1);
		mcqGameRdBtnChoice1.setBounds(6, 36, 227, 23);
		mcqGameChoicesInternalPanel.add(mcqGameRdBtnChoice1);
		
		JRadioButton mcqGameRdBtnChoice2 = new JRadioButton("Choice 2");
		mcqGameChoicesButtonGroup.add(mcqGameRdBtnChoice2);
		mcqGameRdBtnChoice2.setBounds(6, 72, 227, 23);
		mcqGameChoicesInternalPanel.add(mcqGameRdBtnChoice2);
		
		JRadioButton mcqGameRdBtnChoice3 = new JRadioButton("Choice 3");
		mcqGameChoicesButtonGroup.add(mcqGameRdBtnChoice3);
		mcqGameRdBtnChoice3.setBounds(6, 108, 227, 23);
		mcqGameChoicesInternalPanel.add(mcqGameRdBtnChoice3);
		
		JRadioButton mcqGameRdBtnChoice4 = new JRadioButton("Choice 4");
		mcqGameChoicesButtonGroup.add(mcqGameRdBtnChoice4);
		mcqGameRdBtnChoice4.setBounds(6, 144, 227, 23);
		mcqGameChoicesInternalPanel.add(mcqGameRdBtnChoice4);
		
		JButton mcqGameBtnNextQues = new JButton("Next Question");
		mcqGameBtnNextQues.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
				String type="";
				Enumeration<AbstractButton> buto = mcqGameChoicesButtonGroup.getElements();
				while(buto.hasMoreElements())
				{
					JRadioButton jrd = (JRadioButton) buto.nextElement();
					if(jrd.isSelected()){
						type = jrd.getText();
					}
				}
				if(McQ_Game.getQuestions().get(McQCnt).GetAnswer().equals(type))
				{
					JOptionPane.showMessageDialog(null, "Correct Answer");
					McQCnt++;
					if(McQCnt==McQ_Game.getQuestions().size())
					{
						JOptionPane.showMessageDialog(null, "Congratss");
						mcqGamePanel.setVisible(false);
						playGamePanel.setVisible(true);
					}
					else
					{
						mcqGameQuesTxtField.setText(McQ_Game.Questions.get(McQCnt).GetQuestion());
						mcqGameRdBtnChoice1.setText(McQ_Game.Questions.get(McQCnt).choices[0]);
						mcqGameRdBtnChoice2.setText(McQ_Game.Questions.get(McQCnt).choices[1]);
						mcqGameRdBtnChoice3.setText(McQ_Game.Questions.get(McQCnt).choices[2]);
						mcqGameRdBtnChoice4.setText(McQ_Game.Questions.get(McQCnt).choices[3]);
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Wrong Answer");
				}
				
			}
		});
		mcqGameBtnNextQues.setEnabled(false);
		mcqGameBtnNextQues.setFont(new Font("Chiller", Font.BOLD, 20));
		mcqGameBtnNextQues.setBounds(615, 353, 140, 38);
		mcqGamePanel.add(mcqGameBtnNextQues);
		
		JButton mcqGameBtnShowAns = new JButton("Show Answer");
		mcqGameBtnShowAns.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"The Correct Answer is :"+ McQ_Game.getQuestions().get(McQCnt).GetAnswer());
				McQCnt++;
				if(McQCnt==McQ_Game.getQuestions().size())
				{
					JOptionPane.showMessageDialog(null, "Congratss");
					mcqGamePanel.setVisible(false);
					playGamePanel.setVisible(true);
				}
				else
				{
					mcqGameQuesTxtField.setText(McQ_Game.Questions.get(McQCnt).GetQuestion());
					mcqGameRdBtnChoice1.setText(McQ_Game.Questions.get(McQCnt).choices[0]);
					mcqGameRdBtnChoice2.setText(McQ_Game.Questions.get(McQCnt).choices[1]);
					mcqGameRdBtnChoice3.setText(McQ_Game.Questions.get(McQCnt).choices[2]);
					mcqGameRdBtnChoice4.setText(McQ_Game.Questions.get(McQCnt).choices[3]);
				}
			}
		});
		mcqGameBtnShowAns.setEnabled(false);
		mcqGameBtnShowAns.setFont(new Font("Chiller", Font.BOLD, 20));
		mcqGameBtnShowAns.setBounds(465, 353, 140, 38);
		mcqGamePanel.add(mcqGameBtnShowAns);
		
		JButton mcqGameBtnStartGame = new JButton("Start Game");
		mcqGameBtnStartGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				McQCnt=0;
				mcqGameBtnStartGame.setEnabled(false);
				mcqGameBtnShowAns.setEnabled(true);
				mcqGameBtnNextQues.setEnabled(true);
				
				mcqGameQuesTxtField.setText(McQ_Game.Questions.get(0).GetQuestion());
				mcqGameRdBtnChoice1.setText(McQ_Game.Questions.get(0).choices[0]);
				mcqGameRdBtnChoice2.setText(McQ_Game.Questions.get(0).choices[1]);
				mcqGameRdBtnChoice3.setText(McQ_Game.Questions.get(0).choices[2]);
				mcqGameRdBtnChoice4.setText(McQ_Game.Questions.get(0).choices[3]);
			}
		});
		mcqGameBtnStartGame.setFont(new Font("Chiller", Font.BOLD, 20));
		mcqGameBtnStartGame.setBounds(315, 353, 140, 38);
		mcqGamePanel.add(mcqGameBtnStartGame);
		
		JButton button_2 = new JButton("Profile");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				if(theAccount.isType())
				{
					mcqGamePanel.setVisible(false);
					sProfilePanel.setVisible(true);
				}
				else
				{
					mcqGamePanel.setVisible(false);
					tProfilePanel.setVisible(true);
				}
			}
		});
		button_2.setFont(new Font("Chiller", Font.BOLD, 20));
		button_2.setBounds(0, 0, 88, 45);
		mcqGamePanel.add(button_2);
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(545, 143, 230, 229);
		playGamePanel.add(scrollPane);
		
		JList playGameSubjectList = new JList();
		scrollPane.setViewportView(playGameSubjectList);
		
		JButton playGameBtnPlayGame = new JButton("Play Game");
		playGameBtnPlayGame.setFont(new Font("Chiller", Font.BOLD, 18));
		playGameBtnPlayGame.setEnabled(false);
		playGameBtnPlayGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				playGameSubjectList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				String selectedGame = (String) playGameSubjectList.getSelectedValue();
				System.out.println("selected game :: " + selectedGame);
				if(selectedGame.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Please Select the Subject");
				}else{
					
					Game thG= control.getGame(selectedGame);
					if(thG instanceof T_F){
						tfGame = (T_F)thG;
						playGameBtnPlayGame.setEnabled(false);
						playGameBtnGetSubjects.setEnabled(true);
						t_fGamePanel.setVisible(true);
						playGamePanel.setVisible(false);
						
						
					}else if(thG instanceof McQ){
						McQ_Game= (McQ) thG;
						playGameBtnPlayGame.setEnabled(false);
						playGameBtnGetSubjects.setEnabled(true);
						mcqGamePanel.setVisible(true);
						playGamePanel.setVisible(false);
					}else if(thG instanceof Match){
						match_game = (Match) thG;
						playGameBtnPlayGame.setEnabled(false);
						playGameBtnGetSubjects.setEnabled(true);
						mtGamePanel.setVisible(true);
						playGamePanel.setVisible(false);
						
					}
					
				}
				
				
			}
		});
		playGameBtnPlayGame.setBounds(10, 328, 194, 44);
		playGamePanel.add(playGameBtnPlayGame);
		
		
		JButton playGameBtnShowGames = new JButton("Show Games");
		playGameBtnShowGames.setFont(new Font("Chiller", Font.BOLD, 18));
		playGameBtnShowGames.setEnabled(false);
		playGameBtnShowGames.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				
				playGameSubjectList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				String selectedSubject = (String) playGameSubjectList.getSelectedValue();
				//System.out.println("Selected :: " + selectedSubject);
				
				if(selectedSubject.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Please Select the Subject");
				}else{
					int c = 0;
					if(gameTypeStr.equals("MCQ"))
					{
						c=2;
					}
					else if(gameTypeStr.equals("Match"))
					{
						c=1;
					}
					else if(gameTypeStr.equals("T/F"))
					{
						c=0;
					}
					Vector<Game> tmp = new  Vector<Game>();
					tmp = control.GetAllGame(c,selectedSubject );
					Vector<String> nam = new Vector<String>();
					for(Game s : tmp){
						nam.addElement(s.getName());
					}
					//nam.add("FIFA");
					//nam.add("PES");
					
					DefaultListModel dlm2 = new DefaultListModel();
					for(int i = 0 ; i < nam.size() ; i++)
					{
						dlm2.addElement(nam.get(i));
					}
					playGameSubjectList.setModel(dlm2);
					
					playGameBtnShowGames.setEnabled(false);
					playGameBtnPlayGame.setEnabled(true);
				}
				
				
				
			}
		});
		playGameBtnShowGames.setBounds(10, 272, 194, 45);
		playGamePanel.add(playGameBtnShowGames);
		
		
		
		playGameBtnGetSubjects.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Enumeration<AbstractButton> buto4 = PlayGameGameTypeButtonGroup.getElements();
				while(buto4.hasMoreElements())
				{
					JRadioButton jrd4 = (JRadioButton) buto4.nextElement();
					if(jrd4.isSelected()){
						gameTypeStr = jrd4.getText();
					}
				}
				int c = 0;
				if(gameTypeStr.equals("MCQ"))
				{
					c=2;
				}
				else if(gameTypeStr.equals("Match"))
				{
					c=1;
				}
				else if(gameTypeStr.equals("T/F"))
				{
					c=0;
				}
				
				Vector<String> tmp = new Vector<String>();
				tmp = control.GetallSubject(c);
				//tmp.add("Math");
				//tmp.add("Code");
				DefaultListModel dlm = new DefaultListModel();
				for(int i = 0 ; i < tmp.size() ; i++)
				{
					dlm.addElement(tmp.get(i));
				}
				playGameSubjectList.setModel(dlm);
				
				playGameBtnGetSubjects.setEnabled(false);
				playGameBtnShowGames.setEnabled(true);
				//playGameBtnPlayGame.setEnabled(false);
				//////////////////////////////////////////////////////////////////////////////
				
				
				
			}
		});
		playGameBtnGetSubjects.setBounds(10, 216, 194, 45);
		playGamePanel.add(playGameBtnGetSubjects);
		
		JPanel playGameGameTypeInternalPanel = new JPanel();
		playGameGameTypeInternalPanel.setLayout(null);
		playGameGameTypeInternalPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Game Type", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		playGameGameTypeInternalPanel.setBounds(10, 71, 194, 117);
		playGamePanel.add(playGameGameTypeInternalPanel);
		
		JRadioButton playGameRdBtnMcq = new JRadioButton("MCQ");
		PlayGameGameTypeButtonGroup.add(playGameRdBtnMcq);
		playGameRdBtnMcq.setSelected(true);
		playGameRdBtnMcq.setBounds(20, 36, 111, 25);
		playGameGameTypeInternalPanel.add(playGameRdBtnMcq);
		
		JRadioButton playGameRdBtnMatch = new JRadioButton("Match");
		PlayGameGameTypeButtonGroup.add(playGameRdBtnMatch);
		playGameRdBtnMatch.setBounds(20, 64, 111, 25);
		playGameGameTypeInternalPanel.add(playGameRdBtnMatch);
		
		JRadioButton playGameRdBtnT_F = new JRadioButton("T/F");
		PlayGameGameTypeButtonGroup.add(playGameRdBtnT_F);
		playGameRdBtnT_F.setBounds(20, 87, 111, 25);
		playGameGameTypeInternalPanel.add(playGameRdBtnT_F);
		
		JLabel lblNewLabel_11 = new JLabel("Play Game");
		lblNewLabel_11.setFont(new Font("Chiller", Font.BOLD, 40));
		lblNewLabel_11.setBounds(304, 11, 144, 51);
		playGamePanel.add(lblNewLabel_11);
		
		JButton button_1 = new JButton("Profile");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(theAccount.isType())
				{
					playGamePanel.setVisible(false);
					sProfilePanel.setVisible(true);
				}
				else
				{
					playGamePanel.setVisible(false);
					tProfilePanel.setVisible(true);
				}
			}
		});
		button_1.setFont(new Font("Chiller", Font.BOLD, 20));
		button_1.setBounds(0, 0, 88, 45);
		playGamePanel.add(button_1);
		
		
	
		
	}

	





	

	
}
