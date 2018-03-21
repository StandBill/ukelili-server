package dao;

import java.util.List;

import model.*;

public interface VideoMapper {
	public VideoInfo getVideo(String id);
	
	public List<VideoInfo> getAllVideo(VideoInfo vi);
	
	public int addVideo(VideoInfo vi);
	
	public int delVideo(String[] id);
	
	public int updateVideo(VideoInfo vi);
	
	public int count(VideoInfo vi);
	
	public int upComs(VideoInfo id);
	
	public int forbitComs(String[] ids);
	
	public int forbitDown(String[] ids);
	
	public int forbitTransmit(String[] ids);
	
	public List<VideoInfo> search(SearchKeyInfo ski);
	
	public int upStatus(String srcAddress);

	public int upDowns(VideoInfo video);
	
	public int upTransmit(VideoInfo video);
	
}
