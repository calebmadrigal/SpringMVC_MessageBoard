package com.spiderlogic.controller;

import com.spiderlogic.model.Message;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
@RequestMapping("/")
public class MessageBoardController {
    private ArrayList<String> messages;

    public MessageBoardController() {
        messages = new ArrayList<String>();
    }

	@RequestMapping(value="{messageId}", method = RequestMethod.GET)
	public String viewMessage(@PathVariable int messageId, ModelMap model) {
		String post = "No message with that ID.";
        if (this.messages.size() > messageId) {
            post = this.messages.get(messageId);
        }
		model.addAttribute("messageText", post);
		return "singlemessage";
	}

    @RequestMapping(value={"", "/", "list"}, method = RequestMethod.GET)
	public String viewAllMessages(ModelMap model) {
		model.addAttribute("allMessages", stringListToMessageList());
		return "list";
	}

    @RequestMapping(value="/messageform", method = RequestMethod.GET)
    public String addMessageForm(ModelMap model) {
        return "messageform";
    }

    @RequestMapping(value="/add", method = RequestMethod.POST)
	public String addMessage(@RequestParam("message") String message, ModelMap model) {
        this.messages.add(message);
		model.addAttribute("allMessages", stringListToMessageList());
		return "list";
	}

    private ArrayList<Message> stringListToMessageList() {
        ArrayList<Message> messageList = new ArrayList<Message>(this.messages.size());
        for(int i = 0; i < this.messages.size(); i++) {
            messageList.add(new Message(i, this.messages.get(i)));
        }
        return messageList;
    }
}
