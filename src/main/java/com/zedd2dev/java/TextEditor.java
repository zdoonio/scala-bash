package com.zedd2dev.java;

/**
 * Created by Dominik Zduńczyk on 16.04.19.
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class TextEditor extends JFrame implements ActionListener
{
	private TextArea text;
	private Font mainFont;

	private TextEditor(String mainTitle)
	{
		super(mainTitle);

		Menu file, edit,format,font,font1,font2;
		MenuBar menuBar;
		JPanel mainPanel;

		MenuItem item1,item2,item3,item4;
		MenuItem item5,item6,item7,item8,item9,item10;
		MenuItem fname1,fname2,fname3,fname4;
		MenuItem fstyle1,fstyle2,fstyle3,fstyle4;
		MenuItem fsize1,fsize2,fsize3,fsize4;

		mainPanel=(JPanel)getContentPane();
		mainPanel.setLayout(new FlowLayout());

		menuBar = new MenuBar();
		setMenuBar(menuBar);

		file = new Menu("File");
		edit = new Menu("Edit");
		format = new Menu("Format");
		font = new Menu("Font");
		font1 = new Menu("Font Style");
		font2 = new Menu("Size");

		file.add(item1 = new MenuItem("New..."));
		file.add(item2 = new MenuItem("Open"));
		file.add(item3 = new MenuItem("Save As..."));
		file.add(item4 = new MenuItem("Exit"));
		menuBar.add(file);


		edit.add(item5 = new MenuItem("Cut (Ctrl+X)"));
		edit.add(item6 = new MenuItem("Copy (Ctrl+C)"));
		edit.add(item7 = new MenuItem("Paste (Ctrl+V)"));
		edit.add(item8 = new MenuItem("Delete"));
		edit.add(item10 = new MenuItem("Select All (Ctrl+A)"));
		edit.add(item9 = new MenuItem("Time/Date"));
		menuBar.add(edit);

		format.add(font);
		format.add(font1);
		format.add(font2);

		font.add(fname1 = new MenuItem("Courier"));
		font.add(fname2 = new MenuItem("Sans Serif"));
		font.add(fname3 = new MenuItem("Monospaced"));
		font.add(fname4 = new MenuItem("Symbol"));

		font1.add(fstyle1 = new MenuItem("Regular"));
		font1.add(fstyle2 = new MenuItem("Bold"));
		font1.add(fstyle3 = new MenuItem("Italic"));
		font1.add(fstyle4 = new MenuItem("Bold Italic"));

		font2.add(fsize1 = new MenuItem("12"));
		font2.add(fsize2 = new MenuItem("14"));
		font2.add(fsize3 = new MenuItem("18"));
		font2.add(fsize4 = new MenuItem("20"));

		menuBar.add(format);

		item1.addActionListener(this);
		item2.addActionListener(this);
		item3.addActionListener(this);
		item4.addActionListener(this);
		item5.addActionListener(this);
		item6.addActionListener(this);
		item7.addActionListener(this);
		item8.addActionListener(this);
		item9.addActionListener(this);
		item10.addActionListener(this);
		fname1.addActionListener(this);
		fname2.addActionListener(this);
		fname3.addActionListener(this);
		fname4.addActionListener(this);
		fstyle1.addActionListener(this);
		fstyle2.addActionListener(this);
		fstyle3.addActionListener(this);
		fstyle4.addActionListener(this);
		fsize1.addActionListener(this);
		fsize2.addActionListener(this);
		fsize3.addActionListener(this);
		fsize4.addActionListener(this);


		text = new TextArea(26,60);
		mainPanel.add(text);

		mainFont = new Font("Monotype Corsiva",Font.PLAIN,15);
		text.setFont(mainFont);
	}

	private void setFont(String fontName, int fontStyle, int fontSize) {
		mainFont = new Font(fontName, fontStyle, fontSize);
		text.setFont(mainFont);
	}

	public static void createNewWindow() {
		TextEditor note = new TextEditor("JavPad");
		note.setSize(620,580);
		note.setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {
		String command;
		String str = " ";
		String str1 ,str2, str3, str4, str6, str7, str8 = " ", str9;
		int len1, i, pos1, len;

		command= ae.getActionCommand();

		switch (command) {

			case "New...":
				dispose();
				createNewWindow();
				break;

			case "Open":
				str4=" ";
				FileDialog dialog=new FileDialog(this,"Open");
				dialog.setVisible(true);

				str1=dialog.getDirectory();
				str2=dialog.getFile();
				str3=str1+str2;
				File f=new File(str3);
				try {
					FileInputStream fobj=new FileInputStream(f);
					len=(int)f.length();
					for(int j=0;j<len;j++) {
						char str5=(char)fobj.read();
						str4=str4 + str5;

					}
				} catch(IOException e) { System.out.println(e.toString());}

				text.setText(str4);
				break;

			case "Save As...":
				FileDialog dialog1=new FileDialog(this,"Save As",FileDialog.SAVE);
				dialog1.setVisible(true);

				str7=dialog1.getDirectory();
				str8=dialog1.getFile();
				str9=str7+str8;


				str6=text.getText();
				len1=str6.length();
				byte buf[]=str6.getBytes();
				try {
					File f1=new File(str9);

					FileOutputStream fobj1=new FileOutputStream(f1);
					for(int k=0;k<len1;k++) {
						fobj1.write(buf[k]);
					}

					fobj1.close();
				} catch(IOException e) { System.out.println(e.toString());}


				this.setTitle(str8);
				break;

			case "Exit":
				System.exit(0);
				break;

			case "Cut (Ctrl+X)":
				str = text.getSelectedText();
				i = text.getText().indexOf(str);
				text.replaceRange(" ",i,i+str.length());
				break;

			case "Copy (Ctrl+C)":
				str = text.getSelectedText();
				break;

			case "Paste (Ctrl+V)":
				pos1=text.getCaretPosition();
				text.insert(str,pos1);
				break;

			case "Select All (Ctrl+A)":
				String strText=text.getText();
				int strLen=strText.length();
				text.select(0,strLen);
				break;

			case "Delete":
				String msg=text.getSelectedText();
				i=text.getText().indexOf(msg);
				text.replaceRange(" ",i,i+msg.length());
				break;

			case "Time/Date":
				String months[]={
						"Jan","Feb","Mar","Apr",
						"May","Jun","Jul","Aug",
						"Sep","Oct","Nov","Dec"};

				GregorianCalendar calendar = new GregorianCalendar();
				String h=String.valueOf(calendar.get(Calendar.HOUR));
				String m=String.valueOf(calendar.get(Calendar.MINUTE));
				String s=String.valueOf(calendar.get(Calendar.SECOND));
				String date=String.valueOf(calendar.get(Calendar.DATE));
				String mon=months[calendar.get(Calendar.MONTH)];
				String year=String.valueOf(calendar.get(Calendar.YEAR));
				String hms="Time"+" - "+h+":"+m+":"+s+" Date"+" - "+date+" "+mon+" "+year;
				int loc=text.getCaretPosition();
				text.insert(hms,loc);
				break;

			case "Courier":
				setFont("Courier", mainFont.getStyle(), mainFont.getSize());
				break;

			case "Sans Serif":
				setFont("Sans Serif", mainFont.getStyle(), mainFont.getSize());
				break;

			case "Monospaced":
				setFont("Monospaced", mainFont.getStyle(), mainFont.getSize());
				break;

			case "Symbol":
				setFont("Symbol", mainFont.getStyle(), mainFont.getSize());
				break;

			case "Regular":
				setFont(mainFont.getName(), Font.PLAIN, mainFont.getSize());
				break;

			case "Bold":
				setFont(mainFont.getName(), Font.BOLD, mainFont.getSize());
				break;

			case "Italic":
				setFont(mainFont.getName(), Font.ITALIC, mainFont.getSize());
				break;

			case "Bold Italic":
				setFont(mainFont.getName(), Font.BOLD|Font.ITALIC, mainFont.getSize());
				break;

			case "12":
				setFont(mainFont.getName(), mainFont.getStyle(), 12);
				break;

			case "14":
				setFont(mainFont.getName(), mainFont.getStyle(), 14);
				break;

			case "18":
				setFont(mainFont.getName(), mainFont.getStyle(), 18);
				break;

			case "20":
				setFont(mainFont.getName(), mainFont.getStyle(), 20);
				break;

		}

	}

	public static void main(String args[]) {
		createNewWindow();
	}
}
