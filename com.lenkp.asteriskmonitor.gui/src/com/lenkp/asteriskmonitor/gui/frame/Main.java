package com.lenkp.asteriskmonitor.gui.frame;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.lenkp.asteriskmonitor.gui.GuiActivator;

import ch.loway.oss.ari4java.generated.Bridge;
import ch.loway.oss.ari4java.generated.Endpoint;

public class Main {

	private JFrame frame;
	private JTable table;
	private JTable table1;
	private JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main() {
		try 
	    { 
	        UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel"); 
	    } 
	    catch(Exception e){ 
	    }
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("serial")
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 890, 576);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 890, 25);
		frame.getContentPane().add(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		mnFile.add(mntmExit);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mnHelp.add(mntmAbout);
		
		JButton btnButton = new JButton("Setting");
		btnButton.setBounds(12, 27, 117, 28);
		btnButton.setVisible(true);
		btnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(frame,
					    "Eggs are not supposed to be green.",
					    "Inane warning",
					    JOptionPane.WARNING_MESSAGE);
			}
		});
		
		/***Tab section***/
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(12, 57, 860, 480);
		frame.getContentPane().add(tabbedPane);
		
		frame.getContentPane().add(btnButton);
		
		//===== first Tab =====//
		panel = new JPanel();
		tabbedPane.addTab("EndPoints", null, panel, null);
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		
		JSeparator separator = new JSeparator(SwingConstants.VERTICAL);
		separator.setBounds(615, 15, 5, 420);
		separator.setBackground(Color.BLUE);
		separator.setForeground(Color.BLUE);
		
		JLabel sipLabel = new JLabel();
        sipLabel.setBounds(625, 15, 400, 30);
        
        JLabel hostSipLabel = new JLabel();
        hostSipLabel.setBounds(625, 50, 400, 30);
        
        JButton button = new JButton();
		button.setBounds(625, 90, 100, 30);
		button.setBackground(Color.BLACK);
		button.setVisible(false);
		
		//start data table listener 
		DefaultTableModel tableModelEndPoints = new DefaultTableModel(new String[] { "SIP","Host","Status","Action"},0);
		DefaultTableModel tableModelBridges = new DefaultTableModel(new String[] { "Bridges", "Action" },0);
		
		tableModelEndPoints.setRowCount(0);
		tableModelBridges.setRowCount(0);
		
		for (Endpoint endpoint : GuiActivator.getEndpointService().getEndpoints()) {
			tableModelEndPoints.addRow(new Object[]{endpoint.getResource(),endpoint.getResource(),endpoint.getState(),"Info"});
		}
		
		for (Bridge bridge : GuiActivator.getBridgeService().getBridges()) {
			tableModelBridges.addRow(new Object[]{bridge.getName(), "Action"});
		}
		
		//insert data Ari SIP into table
		table = new JTable(tableModelEndPoints){
		    @Override
		    public boolean isCellEditable(int row, int column) {
		        return this.getColumnName(column).equals("Action") ? true : false;
		    }
		};
		//end listener
		
		Action getSIPInfo = new AbstractAction()
        {
            public void actionPerformed(ActionEvent e)
            {
                JTable table = (JTable)e.getSource();
                int modelRow = Integer.valueOf( e.getActionCommand() );
                System.out.println(table.getModel().getValueAt(modelRow, 0).toString());
                
        		sipLabel.setText("SIP : " + table.getModel().getValueAt(modelRow, 0).toString());
        		
        		sipLabel.setFont(new Font("Sans", Font.BOLD, 12));
        		
        		hostSipLabel.setText("Host : " + table.getModel().getValueAt(modelRow, 1).toString());
        		
        		hostSipLabel.setFont(new Font("Sans", Font.BOLD, 12));
        		
        		button.setText("Edit");
        		button.setVisible(true);
            }
        };
        new ButtonColumn(table, getSIPInfo, 3);
        
        table.getColumnModel().getColumn(2).setCellRenderer(new StatusColumnCellRenderer());
        table.setRowHeight(25);
        
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(12, 12, 600, 420);
		
		panel.add(scrollPane);
		panel.add(sipLabel);
		panel.add(hostSipLabel);
		panel.add(button);
		panel.add(separator);
		
		/*** second Tab ***/
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Bridges", null, panel_1, null);
		panel_1.setLayout(null);
		panel_1.setBackground(Color.WHITE);
		//First Panel
		table1 = new JTable(tableModelBridges);
		table1.setRowHeight(25);
		
		JScrollPane scrollPane_2 = new JScrollPane();
        scrollPane_2.setBounds(295, 12, 550, 420);
		scrollPane_2.setVisible(true);
		
		Action getBridgeChannels = new AbstractAction()
        {
            public void actionPerformed(ActionEvent e)
            {
                JTable table = (JTable)e.getSource();
                int modelRow = Integer.valueOf( e.getActionCommand() );
        		
                System.out.println(table.getModel().getValueAt(modelRow, 0).toString());
                //ambil channel pada bridges dan masukan kedalam table
                DefaultTableModel bridgesChannelsModel = new DefaultTableModel(new String[] { "SIP","Host","Action"},0);
                //dibawah ini contoh
                for (int i=0; i<25; i++) {
                	bridgesChannelsModel.addRow(new Object[]{"SIP "+ (i+1) + " " + table.getModel().getValueAt(modelRow, 0).toString(),"192.168.10.10","Kick"});
                }
                
                JTable bridgeChannelsTable =  new JTable();
                bridgeChannelsTable.setModel(bridgesChannelsModel);
                bridgeChannelsTable.setRowHeight(25);
                
                Action kickBridgesChannel = new AbstractAction()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                        JTable table = (JTable)e.getSource();
                        int modelRow = Integer.valueOf( e.getActionCommand() );
                        System.out.println("kick " + table.getModel().getValueAt(modelRow, 0).toString());
                        ((DefaultTableModel)table.getModel()).removeRow(modelRow);
                    }
                };
                new ButtonColumn(bridgeChannelsTable, kickBridgesChannel, 2);
                
                scrollPane_2.setViewportView(bridgeChannelsTable);
            }
        };
        new ButtonColumn(table1, getBridgeChannels, 1);
		
		JScrollPane scrollPane_1 = new JScrollPane(table1);
		scrollPane_1.setBounds(12, 12, 270, 420);
		scrollPane_1.setVisible(true);
		
		panel_1.add(scrollPane_1);
		panel_1.add(scrollPane_2);
	}
}

@SuppressWarnings("serial")
class StatusColumnCellRenderer extends DefaultTableCellRenderer {
  @Override
  public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int col) {
	
	  Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col); 
	  
	  if(table.getModel().getValueAt(row, 2).toString().equals("Online"))
	        c.setBackground(Color.GREEN);
	    else
	        c.setBackground(Color.RED);

    //Return the Component which renders the cell.
	  return c;
  }
}