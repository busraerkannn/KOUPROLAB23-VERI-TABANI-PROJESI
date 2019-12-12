/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author gozde
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sound.midi.Soundbank;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;





public class Arayuz extends JFrame {
	
	private JTextField txt1;
	private JTable t_tedarikci;

	DefaultTableModel modelim1 = new DefaultTableModel();
	DefaultTableModel modelim2 = new DefaultTableModel();
	DefaultTableModel modelim3 = new DefaultTableModel();
	DefaultTableModel modelim4 = new DefaultTableModel();
	DefaultTableModel modelim5 = new DefaultTableModel();
	DefaultTableModel modelim6 = new DefaultTableModel();
	DefaultTableModel modelim7 = new DefaultTableModel();
	DefaultTableModel modelim8 = new DefaultTableModel();
	DefaultTableModel modelim9 = new DefaultTableModel();
	DefaultTableModel modelim10 = new DefaultTableModel();
	DefaultTableModel modelim11 = new DefaultTableModel();
	
	Object[] kolonlar1 = {"Firma ID","Hammadde","Miktar","Tarih","Raf Ömrü","Satış Fiyatı"};
	Object[] satirlar1 = new Object[6];
	
	Object[] kolonlar2 = {"Firma ID","Firma Adı"};
	Object[] satirlar2 = new Object[2];
	
	Object[] kolonlar3 = {"Firma ID","Ülke","Şehir Merkezi"};
	Object[] satirlar3 = new Object[3];
	
	Object[] kolonlar4 = {"Kimyasal Ürün","Bileşen","Bileşen Sayısı"};
	Object[] satirlar4 = new Object[3];
	
	Object[] kolonlar5 = {"Firma Adı","Hammadde","Maliyet","Stok","Ürün"};
	Object[] satirlar5 = new Object[5];
	
	Object[] kolonlar6 = {"Firma Adı","Şehir"};
	Object[] satirlar6 = new Object[2];
	
	Object[] kolonlar7 = {"Ürün ID","Ürün Adı","Hammadde","Hammadde Miktarı"};
	Object[] satirlar7 = new Object[4];
	
	Object[] kolonlar8 = {"Ürün ID","Üretim Tarihi","Raf Ömrü","İşçilik Maliyeti","Toplam Maliyet","Satış Fiyatı"};
	Object[] satirlar8 = new Object[6];
	
	Object[] kolonlar9 = {"Müşteri ID","Adres","Ürün Bilgisi"};
	Object[] satirlar9 = new Object[3];
	
	Object[] kolonlar10 = {"Müşteri ID","Müşteri Adı"};
	Object[] satirlar10 = new Object[2];
	
	Object[] kolonlar11 = {"Şehir","Mesafe"};
	Object[] satirlar11 = new Object[2];
	
	ArrayList<String> list_firmaID = new ArrayList<String>();
    ArrayList<String> list_miktar = new ArrayList<String>();
    ArrayList<String> list_satisFiyati = new ArrayList<String>();

	
	private JTextField txt2;
	private JTable t_tfirma;
	private JTextField txt3;
	private JTable t_tkonum;
	private JTable t_kimyasalurun;
	private JTextField txt4;
	private JTable t_uretici;
	private JTextField txt5;
	private JTable t_ufirma;
	private JTextField txt6;
	private JTextField txt7;
	private JTable t_uretilenurun;
	private JTable t_uretilenurunbilgi;
	private JTextField txt8;
	private JTable t_musteri;
	private JTextField txt9;
	private JTable t_musteribilgi;
	private JTextField txt10;
	private JTextField txt11;
	private JTable t_ulasim;
	
	
	public Arayuz() throws HeadlessException {
        final JTabbedPane panel = new JTabbedPane();
        panel.setBorder(BorderFactory.createLineBorder(Color.red));
        panel.setPreferredSize(new Dimension(900, 2500));

        final JScrollPane scroll = new JScrollPane(panel);
        
        JPanel panel_1 = new JPanel();
        panel.addTab("Tablolar", null, panel_1, null);
       
       //tedarikci tablosu
       
        
        JLabel lbl1 = new JLabel("Tedarikçi Tablosu  ");
        lbl1.setFont(new Font("Tahoma", Font.BOLD, 15));
        lbl1.setPreferredSize(new Dimension(180,50));
        panel_1.add(lbl1);
        
        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setPreferredSize(new Dimension(600,200));
        
        String tabloAdi1 = "tedarikci";
        modelim1.setColumnIdentifiers(kolonlar1);
        
        t_tedarikci = new JTable();
        scrollPane_1.setViewportView(t_tedarikci);
        
        panel_1.add(scrollPane_1);
        
        JButton btnlistele1 = new JButton("Listele");
        btnlistele1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {

				modelim1.setRowCount(0);
				ResultSet myRs= VeriBaglanti.baglan(tabloAdi1);
					
				try {
					while(myRs.next()) {
						satirlar1[0] = myRs.getString("firmaID");
						satirlar1[1] = myRs.getString("hammadde");
						satirlar1[2] = myRs.getString("miktar");
						satirlar1[3] = myRs.getString("tarih");
						satirlar1[4] = myRs.getString("rafOmru");
						satirlar1[5] = myRs.getString("satisFiyati");
						modelim1.addRow(satirlar1);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					
				t_tedarikci.setModel(modelim1);
				
			}
		});
        btnlistele1.setPreferredSize(new Dimension(75,30));
        panel_1.add(btnlistele1);
        
        //tfirma tablosu
        
        JLabel lbl2 = new JLabel("Firma Tablosu  ");
        lbl2.setFont(new Font("Tahoma", Font.BOLD, 15));
        lbl2.setPreferredSize(new Dimension(180,50));
        panel_1.add(lbl2);
        
        JScrollPane scrollPane_2 = new JScrollPane();
        scrollPane_2.setPreferredSize(new Dimension(600,200));
        panel_1.add(scrollPane_2);
        
        String tabloAdi2 = "tfirma";
        modelim2.setColumnIdentifiers(kolonlar2);
        
        t_tfirma = new JTable();
        scrollPane_2.setViewportView(t_tfirma);
        
        JButton btnlistele2 = new JButton("Listele");
        btnlistele2.addActionListener(new ActionListener() {
			
        	public void actionPerformed(ActionEvent e) {

        		modelim2.setRowCount(0);
				ResultSet myRs= VeriBaglanti.baglan(tabloAdi2);
					
				try {
					while(myRs.next()) {
						satirlar2[0] = myRs.getString("firmaID");
						satirlar2[1] = myRs.getString("firmaAdi");
						modelim2.addRow(satirlar2);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					
				t_tfirma.setModel(modelim2);
			}
		});
        btnlistele2.setPreferredSize(new Dimension(75,30));
        panel_1.add(btnlistele2);
        
        
        
        //tkonum tablosu
      
        JLabel lbl3 = new JLabel("Firma Konum Tablosu  ");
        lbl3.setFont(new Font("Tahoma", Font.BOLD, 15));
        lbl3.setPreferredSize(new Dimension(180,50));
        panel_1.add(lbl3);
        
        JScrollPane scrollPane_3 = new JScrollPane();
        scrollPane_3.setPreferredSize(new Dimension(600,200));
        panel_1.add(scrollPane_3);
        
        String tabloAdi3 = "tkonum";
        modelim3.setColumnIdentifiers(kolonlar3);
        
        t_tkonum = new JTable();
        scrollPane_3.setViewportView(t_tkonum);
        
        JButton btnlistele3 = new JButton("Listele");
        btnlistele3.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				modelim3.setRowCount(0);
				ResultSet myRs= VeriBaglanti.baglan(tabloAdi3);
					
				try {
					while(myRs.next()) {
						satirlar3[0] = myRs.getString("firmaID");
						satirlar3[1] = myRs.getString("ulke");
						satirlar3[2] = myRs.getString("sehirMerkezi");
						modelim3.addRow(satirlar3);
							
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					
				t_tkonum.setModel(modelim3);
				
				
			}
		});
        
        btnlistele3.setPreferredSize(new Dimension(75,30));
        panel_1.add(btnlistele3);
        
        //kimyasal ürün tablosu
 
        JLabel lbl4 = new JLabel("Kimyasal Ürün Tablosu  ");
        lbl4.setFont(new Font("Tahoma", Font.BOLD, 15));
        lbl4.setPreferredSize(new Dimension(180,50));
        panel_1.add(lbl4);
        
        JScrollPane scrollPane_4 = new JScrollPane();
        scrollPane_4.setPreferredSize(new Dimension(600,200));
        panel_1.add(scrollPane_4);
        
        String tabloAdi4 = "kimyasalurun";
        modelim4.setColumnIdentifiers(kolonlar4);
        
        t_kimyasalurun = new JTable();
        scrollPane_4.setViewportView(t_kimyasalurun);
        
        JButton btnlistele4 = new JButton("Listele");
        btnlistele4.addActionListener(new ActionListener() {
			
        	public void actionPerformed(ActionEvent e) {

        		modelim4.setRowCount(0);
				ResultSet myRs= VeriBaglanti.baglan(tabloAdi4);
					
				try {
					while(myRs.next()) {
						satirlar4[0] = myRs.getString("kimyasalUrunAdi");
						satirlar4[1] = myRs.getString("bilesen");
						satirlar4[2] = myRs.getString("bilesenSayisi");
						modelim4.addRow(satirlar4);
							
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					
				t_kimyasalurun.setModel(modelim4);
				
        		
			}
		});
        btnlistele4.setPreferredSize(new Dimension(75,30));
        panel_1.add(btnlistele4);
        
        //uretici tablosu

        JLabel lbl5 = new JLabel("Üretici Tablosu  ");
        lbl5.setFont(new Font("Tahoma", Font.BOLD, 15));
        lbl5.setPreferredSize(new Dimension(180,50));
        panel_1.add(lbl5);
        
        JScrollPane scrollPane_5 = new JScrollPane();
        scrollPane_5.setPreferredSize(new Dimension(600,200));
        panel_1.add(scrollPane_5);
        
        String tabloAdi5 = "uretici";
        modelim5.setColumnIdentifiers(kolonlar5);
        
        t_uretici = new JTable();
        scrollPane_5.setViewportView(t_uretici);
        
        JButton btnlistele5 = new JButton("Listele");
        btnlistele5.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {

				modelim5.setRowCount(0);
				ResultSet myRs= VeriBaglanti.baglan(tabloAdi5);
					
				try {
					while(myRs.next()) {
						satirlar5[0] = myRs.getString("uFirmaAdi");
						satirlar5[1] = myRs.getString("alinanHammadde");
						satirlar5[2] = myRs.getString("alisMaliyeti");
						satirlar5[3] = myRs.getString("stok");
						satirlar5[4] = myRs.getString("kimyasalUrun");
						modelim5.addRow(satirlar5);
							
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					
				t_uretici.setModel(modelim5);
				
			}
		});
        btnlistele5.setPreferredSize(new Dimension(75,30));
        panel_1.add(btnlistele5);
        
        //ureticiFirma tablosu
        
        JLabel lbl6 = new JLabel("Üretici Firma Tablosu  ");
        lbl6.setFont(new Font("Tahoma", Font.BOLD, 15));
        lbl6.setPreferredSize(new Dimension(180,50));
        panel_1.add(lbl6);
        
        JScrollPane scrollPane_6 = new JScrollPane();
        scrollPane_6.setPreferredSize(new Dimension(600,200));
        panel_1.add(scrollPane_6);
        
        String tabloAdi6 = "ufirma";
        modelim6.setColumnIdentifiers(kolonlar6);
        
        t_ufirma = new JTable();
        scrollPane_6.setViewportView(t_ufirma);

        JButton btnlistele6 = new JButton("Listele");
        btnlistele6.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				modelim6.setRowCount(0);
				ResultSet myRs= VeriBaglanti.baglan(tabloAdi6);
					
				try {
					while(myRs.next()) {
						satirlar6[0] = myRs.getString("uFirmaAdi");
						satirlar6[1] = myRs.getString("sehir");
						modelim6.addRow(satirlar6);
							
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					
				t_ufirma.setModel(modelim6);
			}
		});
        
        btnlistele6.setPreferredSize(new Dimension(75,30));
        panel_1.add(btnlistele6);
        
        
        //uretilenurun tablosu
        
        JLabel lbl7 = new JLabel("Üretilen Ürün Tablosu  ");
        lbl7.setFont(new Font("Tahoma", Font.BOLD, 15));
        lbl7.setPreferredSize(new Dimension(180,50));
        panel_1.add(lbl7);
        
        JScrollPane scrollPane_7 = new JScrollPane();
        scrollPane_7.setPreferredSize(new Dimension(600,200));
        panel_1.add(scrollPane_7);
        
        String tabloAdi7 = "uretilenurun";
        modelim7.setColumnIdentifiers(kolonlar7);
        
        t_uretilenurun = new JTable();
        scrollPane_7.setViewportView(t_uretilenurun);
        
        JButton btnlistele7 = new JButton("Listele");
        btnlistele7.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {

				modelim7.setRowCount(0);
				ResultSet myRs= VeriBaglanti.baglan(tabloAdi7);
					
				try {
					while(myRs.next()) {
						satirlar7[0] = myRs.getString("urunID");
						satirlar7[1] = myRs.getString("urunAdi");
						satirlar7[2] = myRs.getString("hammadde");
						satirlar7[3] = myRs.getString("hammaddeMiktari");
						modelim7.addRow(satirlar7);
							
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					
				t_uretilenurun.setModel(modelim7);
			}
		});
        btnlistele7.setPreferredSize(new Dimension(75,30));
        panel_1.add(btnlistele7);
        
        
        //uretilenurunbilgi tablosu

        JLabel lbl8 = new JLabel("Ü.Ürün Bilgisi Tablosu  ");
        lbl8.setFont(new Font("Tahoma", Font.BOLD, 15));
        lbl8.setPreferredSize(new Dimension(180,50));
        panel_1.add(lbl8);
        
        JScrollPane scrollPane_8 = new JScrollPane();
        scrollPane_8.setPreferredSize(new Dimension(600,200));
        panel_1.add(scrollPane_8);
        
        String tabloAdi8 = "uretilenurunbilgi";
        modelim8.setColumnIdentifiers(kolonlar8);
        
        t_uretilenurunbilgi = new JTable();
        scrollPane_8.setViewportView(t_uretilenurunbilgi);
        
        JButton btnlistele8 = new JButton("Listele");
        btnlistele8.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {

				modelim8.setRowCount(0);
				ResultSet myRs= VeriBaglanti.baglan(tabloAdi8);
					
				try {
					while(myRs.next()) {
						satirlar8[0] = myRs.getString("urunID");
						satirlar8[1] = myRs.getString("uretimTarihi");
						satirlar8[2] = myRs.getString("rafOmru");
						satirlar8[3] = myRs.getString("iscilikMaliyeti");
						satirlar8[4] = myRs.getString("toplamMaliyet");
						satirlar8[5] = myRs.getString("satısFiyati");
						modelim8.addRow(satirlar8);
							
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					
				t_uretilenurunbilgi.setModel(modelim8);
				
			}
		});
        btnlistele8.setPreferredSize(new Dimension(75,30));
        panel_1.add(btnlistele8);

        //musteri tablosu

        JLabel lbl9 = new JLabel("Müşteri Tablosu  ");
        lbl9.setFont(new Font("Tahoma", Font.BOLD, 15));
        lbl9.setPreferredSize(new Dimension(180,50));
        panel_1.add(lbl9);
        
        JScrollPane scrollPane_9 = new JScrollPane();
        scrollPane_9.setPreferredSize(new Dimension(600,200));
        panel_1.add(scrollPane_9);
        
        String tabloAdi9 = "musteri";
        modelim9.setColumnIdentifiers(kolonlar9);
        
        t_musteri = new JTable();
        scrollPane_9.setViewportView(t_musteri);

        JButton btnlistele9 = new JButton("Listele");
        btnlistele9.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {

				modelim9.setRowCount(0);
				ResultSet myRs= VeriBaglanti.baglan(tabloAdi9);
					
				try {
					while(myRs.next()) {
						satirlar9[0] = myRs.getString("musteriID");
						satirlar9[1] = myRs.getString("adres");
						satirlar9[2] = myRs.getString("urunBilgisi");
						modelim9.addRow(satirlar9);
							
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					
				t_musteri.setModel(modelim9);
			}
		});
        btnlistele9.setPreferredSize(new Dimension(75,30));
        panel_1.add(btnlistele9);
        
        //musteribilgi tablosu
        
        JLabel lbl10 = new JLabel("Müşteri Bilgi Tablosu  ");
        lbl10.setFont(new Font("Tahoma", Font.BOLD, 15));
        lbl10.setPreferredSize(new Dimension(180,50));
        panel_1.add(lbl10);
        
        JScrollPane scrollPane_10 = new JScrollPane();
        scrollPane_10.setPreferredSize(new Dimension(600,200));
        panel_1.add(scrollPane_10);
        
        String tabloAdi10 = "musteribilgi";
        modelim10.setColumnIdentifiers(kolonlar10);
        
        t_musteribilgi = new JTable();
        scrollPane_10.setViewportView(t_musteribilgi);
 
        JButton btnlistele10 = new JButton("Listele");
        btnlistele10.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				modelim10.setRowCount(0);
				ResultSet myRs= VeriBaglanti.baglan(tabloAdi10);
					
				try {
					while(myRs.next()) {
						satirlar10[0] = myRs.getString("musteriID");
						satirlar10[1] = myRs.getString("musteriAdi");
						modelim10.addRow(satirlar10);
							
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					
				t_musteribilgi.setModel(modelim10);
			}
		});
        btnlistele10.setPreferredSize(new Dimension(75,30));
        panel_1.add(btnlistele10);

        
        //ulasim tablosu
        
        JLabel lbl11 = new JLabel("Ulaşım Tablosu  ");
        lbl11.setFont(new Font("Tahoma", Font.BOLD, 15));
        lbl11.setPreferredSize(new Dimension(180,50));
        panel_1.add(lbl11);
        
        JScrollPane scrollPane_11 = new JScrollPane();
        scrollPane_11.setPreferredSize(new Dimension(600,200));
        panel_1.add(scrollPane_11);
        
        String tabloAdi11 = "ulasim";
        modelim11.setColumnIdentifiers(kolonlar11);
        
        t_ulasim = new JTable();
        scrollPane_11.setViewportView(t_ulasim);
        
        JButton btnlistele11 = new JButton("Listele");
        btnlistele11.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				modelim11.setRowCount(0);
				ResultSet myRs= VeriBaglanti.baglan(tabloAdi11);
					
				try {
					while(myRs.next()) {
						satirlar11[0] = myRs.getString("sehir");
						satirlar11[1] = myRs.getString("mesafe");
						modelim11.addRow(satirlar11);
							
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					
				t_ulasim.setModel(modelim11);
				
			}
		});
       btnlistele11.setPreferredSize(new Dimension(75,30));
       panel_1.add(btnlistele11);
	
        
        JPanel panel_2 = new JPanel();
        panel.addTab("Tedarikçi-Üretici", panel_2);
        
        //Tedarikçi ekleme
         
        JLabel lblTedarikciEkleme = new JLabel("Tedarikçi Ekleme İşlemi");
        lblTedarikciEkleme.setForeground(Color.RED);
        lblTedarikciEkleme.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblTedarikciEkleme.setPreferredSize(new Dimension(900,50));
        panel_2.add(lblTedarikciEkleme);
         
        JLabel lblfirmaID = new JLabel("Firma ID  ");
        lblfirmaID.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblfirmaID.setPreferredSize(new Dimension(300,50));
        panel_2.add(lblfirmaID);
         
        JTextField txt_firmaID = new JTextField();
        txt_firmaID.setPreferredSize(new Dimension(300, 30));
        panel_2.add(txt_firmaID);
        txt_firmaID.setColumns(50);
        
        JLabel lblfirmaAdi = new JLabel("Firma Adı  ");
        lblfirmaAdi.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblfirmaAdi.setPreferredSize(new Dimension(300,50));
        panel_2.add(lblfirmaAdi);
         
        JTextField txt_firmaAdi = new JTextField();
        txt_firmaAdi.setPreferredSize(new Dimension(300, 30));
        panel_2.add(txt_firmaAdi);
        txt_firmaAdi.setColumns(50);
        
        JLabel lblulke = new JLabel("Ülke  ");
        lblulke.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblulke.setPreferredSize(new Dimension(300,50));
        panel_2.add(lblulke);
         
        JTextField txt_ulke = new JTextField();
        txt_ulke.setPreferredSize(new Dimension(300, 30));
        panel_2.add(txt_ulke);
        txt_ulke.setColumns(50);
        
        JLabel lblsehirMerkezi = new JLabel("Şehir Merkezi  ");
        lblsehirMerkezi.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblsehirMerkezi.setPreferredSize(new Dimension(300,50));
        panel_2.add(lblsehirMerkezi);
         
        JTextField txt_sehirMerkezi = new JTextField();
        txt_sehirMerkezi.setPreferredSize(new Dimension(300, 30));
        panel_2.add(txt_sehirMerkezi);
        txt_sehirMerkezi.setColumns(50);

        JLabel lblhammadde = new JLabel("Hammadde  ");
        lblhammadde.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblhammadde.setPreferredSize(new Dimension(300,50));
        panel_2.add(lblhammadde);
         
        JTextField txt_hammadde = new JTextField();
        txt_hammadde.setPreferredSize(new Dimension(300, 30));
        panel_2.add(txt_hammadde);
        txt_hammadde.setColumns(50);
        
        JLabel lblmiktar= new JLabel("Miktar  ");
        lblmiktar.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblmiktar.setPreferredSize(new Dimension(300,50));
        panel_2.add(lblmiktar);
         
        JTextField txt_miktar = new JTextField();
        txt_miktar.setPreferredSize(new Dimension(300, 30));
        panel_2.add(txt_miktar);
        txt_miktar.setColumns(50);
        
        JLabel lbltarih= new JLabel("Tarih  ");
        lbltarih.setFont(new Font("Tahoma", Font.BOLD, 15));
        lbltarih.setPreferredSize(new Dimension(300,50));
        panel_2.add(lbltarih);
         
        JTextField txt_tarih= new JTextField();
        txt_tarih.setPreferredSize(new Dimension(300, 30));
        panel_2.add(txt_tarih);
        txt_tarih.setColumns(50);
        
        JLabel lblrafOmru= new JLabel("Raf Ömrü  ");
        lblrafOmru.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblrafOmru.setPreferredSize(new Dimension(300,50));
        panel_2.add(lblrafOmru);
         
        JTextField txt_rafOmru= new JTextField();
        txt_rafOmru.setPreferredSize(new Dimension(300, 30));
        panel_2.add(txt_rafOmru);
        txt_rafOmru.setColumns(50);
        
        JLabel lblsatisFiyati= new JLabel("Satış Fiyatı  ");
        lblsatisFiyati.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblsatisFiyati.setPreferredSize(new Dimension(300,50));
        panel_2.add(lblsatisFiyati);
         
        JTextField txt_satisFiyati= new JTextField();
        txt_satisFiyati.setPreferredSize(new Dimension(300, 30));
        panel_2.add(txt_satisFiyati);
        txt_satisFiyati.setColumns(50);
       
        JButton btnKaydet1 = new JButton("Kaydet");
		btnKaydet1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String firmaId,firmaAd,ulke,sehirMerkezi,hammadde,miktar,tarih,rafOmru,satisFiyati,sql_sorgu1,sql_sorgu2,sql_sorgu3;

				firmaId = txt_firmaID.getText();
				firmaAd = txt_firmaAdi.getText();
				ulke = txt_ulke.getText();
				sehirMerkezi = txt_sehirMerkezi.getText();
				hammadde = txt_hammadde.getText();
				miktar = txt_miktar.getText();
				tarih = txt_tarih.getText();
				rafOmru = txt_rafOmru.getText();
				satisFiyati = txt_satisFiyati.getText();
				
				sql_sorgu1 = "INSERT INTO tfirma (firmaID,firmaAdi) VALUES ("+ firmaId + ",'" + firmaAd + "')";
				sql_sorgu2 = "INSERT INTO tkonum (firmaID,ulke,sehirMerkezi) VALUES ("+ firmaId + ",'" + ulke + "'," + "'" + sehirMerkezi + "')";
				sql_sorgu3 = "INSERT INTO tedarikci (firmaID,hammadde,miktar,tarih,rafOmru,satisFiyati) VALUES ("+ firmaId + ",'" + hammadde + "'," 
							+ miktar +",'" +tarih+"',"+rafOmru+","+satisFiyati + ")";
				
				VeriBaglanti.ekle(sql_sorgu1);
				VeriBaglanti.ekle(sql_sorgu2);
				VeriBaglanti.ekle(sql_sorgu3);
				
			}
		});
		
		btnKaydet1.setPreferredSize(new Dimension(200, 30));
		panel_2.add(btnKaydet1);
        
        JPanel panel_3 = new JPanel();
        panel.addTab("Üretici-Müşteri",panel_3);
        
        //Müşteri ekleme
        
        JLabel lblMusteriEkleme = new JLabel("Müşteri Ekleme İşlemi");
        lblMusteriEkleme.setForeground(Color.RED);
        lblMusteriEkleme.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblMusteriEkleme.setPreferredSize(new Dimension(900,50));
        panel_3.add(lblMusteriEkleme);
         
        JLabel lblmusteriID = new JLabel("Müşteri ID  ");
        lblmusteriID.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblmusteriID.setPreferredSize(new Dimension(300,50));
        panel_3.add(lblmusteriID);
         
        JTextField txt_musteriID = new JTextField();
        txt_musteriID.setPreferredSize(new Dimension(300, 30));
        panel_3.add(txt_musteriID);
        txt_musteriID.setColumns(50);
        
        JLabel lblmusteriAdi = new JLabel("Müşteri Adı  ");
        lblmusteriAdi.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblmusteriAdi.setPreferredSize(new Dimension(300,50));
        panel_3.add(lblmusteriAdi);
         
        JTextField txt_musteriAdi = new JTextField();
        txt_musteriAdi.setPreferredSize(new Dimension(300, 30));
        panel_3.add(txt_musteriAdi);
        txt_musteriAdi.setColumns(50);
        
        JLabel lbladres = new JLabel("Adres  ");
        lbladres.setFont(new Font("Tahoma", Font.BOLD, 15));
        lbladres.setPreferredSize(new Dimension(300,50));
        panel_3.add(lbladres);
         
        JTextField txt_adres = new JTextField();
        txt_adres.setPreferredSize(new Dimension(300, 30));
        panel_3.add(txt_adres);
        txt_adres.setColumns(50);

        JLabel lblurunBilgisi = new JLabel("Ürün Bilgisi  ");
        lblurunBilgisi.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblurunBilgisi.setPreferredSize(new Dimension(300,50));
        panel_3.add(lblurunBilgisi);
         
        JTextField txt_urunBilgisi = new JTextField();
        txt_urunBilgisi.setPreferredSize(new Dimension(300, 30));
        panel_3.add(txt_urunBilgisi);
        txt_urunBilgisi.setColumns(50);
        
        JButton btnKaydet2 = new JButton("Kaydet");
		btnKaydet2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String musteriID,musteriAd,adres,urunBilgisi,sql_sorgu1,sql_sorgu2;
				
				musteriID = txt_musteriID.getText();
				musteriAd= txt_musteriAdi.getText();
				adres = txt_adres.getText();
				urunBilgisi = txt_urunBilgisi.getText();
				
				sql_sorgu1 = "INSERT INTO musteri (musteriID,adres,urunBilgisi) VALUES ("+ musteriID + ",'" + adres + "'," + "'" + urunBilgisi + "')";
				sql_sorgu2 = "INSERT INTO musteribilgi (musteriID,musteriAdi) VALUES ("+ musteriID + ",'" + musteriAd + "')";
				
				//System.out.println(sql_sorgu1);
				//.out.println(sql_sorgu2);
				
				VeriBaglanti.ekle(sql_sorgu1);
				VeriBaglanti.ekle(sql_sorgu2);
			}
		});
		
		btnKaydet2.setPreferredSize(new Dimension(200, 30));
		panel_3.add(btnKaydet2);
		
		//kimyasal ürün ekleme işlemi
		
		JLabel lblKimyasalUrunEkleme= new JLabel("Kimyasal Ürün Ekleme İşlemi");
		lblKimyasalUrunEkleme.setForeground(new Color(255, 0, 0));
		lblKimyasalUrunEkleme.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblKimyasalUrunEkleme.setPreferredSize(new Dimension(900,50));
        panel_3.add(lblKimyasalUrunEkleme);
         
        JLabel lblkimyasalUrunAdi = new JLabel("Kimyasal Ürün Adı ");
        lblkimyasalUrunAdi.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblkimyasalUrunAdi.setPreferredSize(new Dimension(300,50));
        panel_3.add(lblkimyasalUrunAdi);
         
        JTextField txt_kimyasalUrunAdi = new JTextField();
        txt_kimyasalUrunAdi.setPreferredSize(new Dimension(300, 30));
        panel_3.add(txt_kimyasalUrunAdi);
        txt_kimyasalUrunAdi.setColumns(50);
        
        JLabel lblbilesen1 = new JLabel("1.Bileşen ");
        lblbilesen1.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblbilesen1.setPreferredSize(new Dimension(300,50));
        panel_3.add(lblbilesen1);
         
        JTextField txt_bilesen1 = new JTextField();
        txt_bilesen1.setPreferredSize(new Dimension(300, 30));
        panel_3.add(txt_bilesen1);
        txt_bilesen1.setColumns(50);
        
        JLabel lblbilesenSayisi1 = new JLabel("1.Bileşen Sayısı ");
        lblbilesenSayisi1.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblbilesenSayisi1.setPreferredSize(new Dimension(300,50));
        panel_3.add(lblbilesenSayisi1);
         
        JTextField txt_bilesenSayisi1 = new JTextField();
        txt_bilesenSayisi1.setPreferredSize(new Dimension(300, 30));
        panel_3.add(txt_bilesenSayisi1);
        txt_bilesenSayisi1.setColumns(50);
        
        JLabel lblbilesen2 = new JLabel("2.Bileşen ");
        lblbilesen2.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblbilesen2.setPreferredSize(new Dimension(300,50));
        panel_3.add(lblbilesen2);
         
        JTextField txt_bilesen2 = new JTextField();
        txt_bilesen2.setPreferredSize(new Dimension(300, 30));
        panel_3.add(txt_bilesen2);
        txt_bilesen2.setColumns(50);
        
        JLabel lblbilesenSayisi2 = new JLabel("2.Bileşen Sayısı ");
        lblbilesenSayisi2.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblbilesenSayisi2.setPreferredSize(new Dimension(300,50));
        panel_3.add(lblbilesenSayisi2);
         
        JTextField txt_bilesenSayisi2 = new JTextField();
        txt_bilesenSayisi2.setPreferredSize(new Dimension(300, 30));
        panel_3.add(txt_bilesenSayisi2);
        txt_bilesenSayisi2.setColumns(50);
        
        JLabel lblbilesen3 = new JLabel("3.Bileşen ");
        lblbilesen3.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblbilesen3.setPreferredSize(new Dimension(300,50));
        panel_3.add(lblbilesen3);
         
        JTextField txt_bilesen3 = new JTextField();
        txt_bilesen3.setPreferredSize(new Dimension(300, 30));
        panel_3.add(txt_bilesen3);
        txt_bilesen3.setColumns(50);
        
        JLabel lblbilesenSayisi3 = new JLabel("3.Bileşen Sayısı ");
        lblbilesenSayisi3.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblbilesenSayisi3.setPreferredSize(new Dimension(300,50));
        panel_3.add(lblbilesenSayisi3);
         
        JTextField txt_bilesenSayisi3 = new JTextField();
        txt_bilesenSayisi3.setPreferredSize(new Dimension(300, 30));
        panel_3.add(txt_bilesenSayisi3);
        txt_bilesenSayisi3.setColumns(50);
        
        JButton btnKaydet3 = new JButton("Kaydet");
		btnKaydet3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String kimyasalUrunAdi, bilesen1, bilesen2, bilesen3, bilesenSayisi1, bilesenSayisi2, bilesenSayisi3, sql_sorgu1, sql_sorgu2, sql_sorgu3;
				
				kimyasalUrunAdi = txt_kimyasalUrunAdi.getText();
				bilesen1 = txt_bilesen1.getText();
				bilesenSayisi1 = txt_bilesenSayisi1.getText();
				bilesen2 = txt_bilesen2.getText();
				bilesenSayisi2 = txt_bilesenSayisi2.getText();
				bilesen3 = txt_bilesen3.getText();
				bilesenSayisi3 = txt_bilesenSayisi3.getText();
				
				if(bilesen3.isEmpty() && bilesenSayisi3.isEmpty())
				{
					//bilesen1=null;
					//sql_sorgu1 = "INSERT INTO kimyasalurun (kimyasalUrunAdi,bilesen,bilesenSayisi) VALUES ("+ "'" +  kimyasalUrunAdi + "'," + "'" + bilesen + "'," + bilesenSayisi + ")";
					//sql_sorgu1 = "INSERT INTO kimyasalurun(kimsayalUrunAdi, bilesen, bilesenSayisi) VALUES ((SELECT urunBilgisi from musteri where urunBilgisi<>kimyasalUrunAdi), "+ "'" + bilesen1 + "'," + bilesenSayisi1 + ")";
					
					String tabloAdi1 = "musteri";
					String tabloAdi2  = "uretilenurun";
					String urunBilgisi;
					String urunAdi;
					boolean devam1=true;
					boolean devam2 = true;
					ResultSet myRs1= VeriBaglanti.baglan(tabloAdi1);
					ResultSet myRs2 = VeriBaglanti.baglan(tabloAdi2);
					
					try {
						while(myRs1.next() && devam1) {
							
							urunBilgisi = myRs1.getString("urunBilgisi");
							if(urunBilgisi.equals(kimyasalUrunAdi))
							{
								System.out.println(kimyasalUrunAdi);
								devam1=false;
							}
								
						}
					} catch (SQLException e1) {
						e1.printStackTrace();

					}
					
					try {
						while(myRs2.next() && devam2) {
							
							urunAdi = myRs2.getString("urunAdi");
							if(urunAdi.equals(kimyasalUrunAdi))
							{
								System.out.println(kimyasalUrunAdi);
								devam2=false;
							}
								
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
						
					if(devam1 && devam2)
					{
						sql_sorgu1 = "INSERT INTO kimyasalurun (kimyasalUrunAdi,bilesen,bilesenSayisi) VALUES ("+ "'" +  kimyasalUrunAdi + "'," + "'" + bilesen1 + "'," + bilesenSayisi1 + ")";
						sql_sorgu2 = "INSERT INTO kimyasalurun (kimyasalUrunAdi,bilesen,bilesenSayisi) VALUES ("+ "'" +  kimyasalUrunAdi + "'," + "'" + bilesen2 + "'," + bilesenSayisi2 + ")";
						System.out.println(sql_sorgu1);
						System.out.println(sql_sorgu2);
						VeriBaglanti.ekle(sql_sorgu1);
						VeriBaglanti.ekle(sql_sorgu2);
					}
					else
					{
						System.out.println("Hata!! Bu ürün daha önce üretilmiş!");
						
						JLabel lbluyari1 = new JLabel("Hata!! Bu ürün daha önce üretilmiş! ");
						lbluyari1.setFont(new Font("Tahoma", Font.BOLD, 15));
						lbluyari1.setPreferredSize(new Dimension(300,50));
				        panel_3.add(lbluyari1);

					}
					
				}
			}
		});
		
		btnKaydet3.setPreferredSize(new Dimension(200, 30));
		panel_3.add(btnKaydet3);
		
		//Üretici firmanın hammadde satın alması işlemi ve stok güncellenmesi
		
		String hammadde;
		
		JLabel lblHammaddeSatinAlma= new JLabel("Tedarikçi Firmadan Hammadde Satın Alma İşlemi");
		lblHammaddeSatinAlma.setForeground(new Color(255, 0, 0));
		lblHammaddeSatinAlma.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblHammaddeSatinAlma.setPreferredSize(new Dimension(900,50));
        panel_2.add(lblHammaddeSatinAlma);
         
        JLabel lblhammaddeAdi= new JLabel("Hammadde ");
        lblhammaddeAdi.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblhammaddeAdi.setPreferredSize(new Dimension(300,50));
        panel_2.add(lblhammaddeAdi);
         
        JTextField txt_hammaddeAdi = new JTextField();
        txt_hammaddeAdi.setPreferredSize(new Dimension(300, 30));
        panel_2.add(txt_hammaddeAdi);
        txt_hammaddeAdi.setColumns(50);
        
        JLabel lblhammaddeMiktar= new JLabel("Miktar ");
        lblhammaddeMiktar.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblhammaddeMiktar.setPreferredSize(new Dimension(300,50));
        panel_2.add(lblhammaddeMiktar);
         
        JTextField txt_hammaddeMiktar = new JTextField();
        txt_hammaddeMiktar.setPreferredSize(new Dimension(300, 30));
        panel_2.add(txt_hammaddeMiktar);
        txt_hammaddeMiktar.setColumns(50); 
        
        hammadde = txt_hammaddeAdi.toString();
        
        JButton btnKaydet4 = new JButton("Kaydet");
        btnKaydet4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ResultSet myRs= VeriBaglanti.ara(hammadde);
				
				try {
					while(myRs.next()) {
						String s=myRs.getString("firmaID");
						list_firmaID.add(myRs.getString("firmaID"));
						list_miktar.add(myRs.getString("miktar"));
						list_satisFiyati.add(myRs.getString("satisFiyati"));
						
						System.out.println(list_firmaID);
						System.out.println(s+"ddddd");
							
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
			}
		});
		
        btnKaydet4.setPreferredSize(new Dimension(200, 30));
		panel_2.add(btnKaydet4);
		
		
		
		
		
        
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(scroll, BorderLayout.CENTER);
        setSize(1000, 647);
        setVisible(true);
    }

    public static void main(final String[] args) throws Exception {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Arayuz().setVisible(true);
            }
        });
    }	
	
}

/////*
////    /**
////     * This method is called from within the constructor to initialize the form.
////     * WARNING: Do NOT modify this code. The content of this method is always
////     * regenerated by the Form Editor.
////     */
////    //@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
   
      //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Arayuz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Arayuz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Arayuz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Arayuz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
