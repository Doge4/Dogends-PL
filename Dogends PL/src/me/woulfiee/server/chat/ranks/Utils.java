/**
 * 
 */
package me.woulfiee.server.chat.ranks;

import net.minecraft.server.v1_8_R3.IChatBaseComponent.ChatSerializer;

/**
 * @author Woulfiee
 *
 */
public class Utils {

	public static String playOutChat(String rank, String hoverText) {
		String json = "{text:\"" + rank + "\",hoverEvent:{action:\"show_text\",value:{text:\"\",extra:[{text:\"" + rank
				+ "\n\n" + hoverText + "\"}]}}}";

		String message = ChatSerializer.a(json).getText();
		return " " + message + " §f";
	}

}
