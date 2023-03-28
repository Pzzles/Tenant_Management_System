/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puleproject.service;

import com.puleproject.bean.Message;
import com.puleproject.dao.DAO;
import com.puleproject.dao.MessageModel;
import java.util.List;

/**
 *
 * @author PULE
 */

public class MessangerService extends Service{
      private DAO msgDAO;

    public MessangerService() {
        this.msgDAO = new MessageModel();
    }

    @Override
    public boolean addMessage(Message message) {
        return msgDAO.addMessage(message);
    }

    @Override
    public List<Message> getAllMessages() {
        return msgDAO.getAllMessages();
    }
    
    public Message getOneMessage(String email){
        return msgDAO.getOneMessage(email);
    }
}
