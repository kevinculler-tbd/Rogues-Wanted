package main.java.util;

import main.java.actors.DisplayObject;
import main.java.stateEngines.AbstractEngine;

import com.googlecode.blacken.colors.ColorNames;
import com.googlecode.blacken.colors.ColorPalette;

public class DisplayUtil {
	public static final int SCREEN_WIDTH = 80;
	public static final int SCREEN_HEIGHT = 24;
	private static ColorPalette palette;
	public static void initColorPalette(ColorPalette p){
	 if (p == null) {
         p = new ColorPalette();
         p.addAll(ColorNames.XTERM_256_COLORS, true);
         p.putMapping(ColorNames.SVG_COLORS);
     } 
     palette = p;
	}
	public static void drawScreen(AbstractEngine engine){
		if(palette == null){
			initColorPalette(null);
		}
		DisplayObject[][] screen = engine.getDisplayMap();
		TerminalUtil.clear();
		TerminalUtil.setCurBackground(0x000000);
		TerminalUtil.setCurForeground(0xeeeeee);
		if(screen !=null){
			for(int i =0; i<SCREEN_HEIGHT; ++i){
				for(int j=0;j<SCREEN_WIDTH; ++j){
					 DisplayObject dO = screen[i][j];
					 if(dO!=null){
						 TerminalUtil.setCurBackground(dO.getBackground());   
						 TerminalUtil.setCurForeground(dO.getForeground());
						 TerminalUtil.output(String.format("%s", dO.getCharacter())); //$NON-NLS-1$
					 }else{
						 TerminalUtil.setCurBackground(0x000000);   
						 TerminalUtil.setCurForeground(0xeeeeee);
						 TerminalUtil.output(String.format("%s", " ")); //$NON-NLS-1$
					 }
				}
				TerminalUtil.output("\n");
	        }
		}
		TerminalUtil.setCurBackground(0x000000);
		TerminalUtil.setCurForeground(0xeeeeee);
		String outputText = engine.getOutputText();
		if(outputText!=null){
			TerminalUtil.output(outputText);
		}
	}
	
	
}
