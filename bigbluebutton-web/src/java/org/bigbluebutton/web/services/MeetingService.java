package org.bigbluebutton.web.services;

import java.util.Collection;
import org.bigbluebutton.api.domain.Meeting;

public interface MeetingService {
	public void cleanupOldMeetings();
	public Collection<Meeting> getAllMeetings();	
	public void storeMeeting(Meeting conf);	
	public Meeting getMeeting(String meetingID);	
	public boolean isMeetingWithVoiceBridgeExist(String voiceBridge);
}
