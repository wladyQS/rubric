package org.rubric.dao;

import org.rubric.domain.Ad;

public interface EmailDAO {
    void sendEmails(Ad ad);
}
