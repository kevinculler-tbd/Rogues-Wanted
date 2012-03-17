package main.java.util;

import com.googlecode.blacken.swing.SwingTerminal;
import com.googlecode.blacken.terminal.BlackenMouseEvent;
import com.googlecode.blacken.terminal.TerminalInterface;

public class TerminalUtil {
    private static TerminalInterface term;

	public static TerminalInterface getTerm() {
		return term;
	}

	public static void setTerm(TerminalInterface term) {
		TerminalUtil.term = term;
	}
	
	public static void initTerm(String winName, int rows, int columns){
		 if (term == null) {
	            term = new SwingTerminal();
	            term.init(winName, rows, columns); //$NON-NLS-1$
	        } else {
	           System.console().printf("OMGWTFBBQ");
	        }
	}
	public static void quit(){
		term.quit();
	}
	
	public static void setCurBackground(int bg){
	 term.setCurBackground(bg);
	}
	public static void setCurForeground(int fg){
     term.setCurForeground(fg);
	}
	public static void  output(String out){
     term.puts(out); //$NON-NLS-1$
	}
	public static void clear(){
		term.clear();
	}
	
	public static BlackenMouseEvent getMouse(){
		return term.getmouse();
	}
}
