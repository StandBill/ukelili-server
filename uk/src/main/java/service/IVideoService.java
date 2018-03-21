package service;

import java.util.List;

import model.SearchKeyInfo;
import model.VideoInfo;

public interface IVideoService {
	public VideoInfo getVideoById(String id);

	public List<VideoInfo> getAll(VideoInfo vi);

	public int updateVideo(VideoInfo vi);

	public int delVideo(String[] id);

	public int addVideo(VideoInfo vi);

	public int count(VideoInfo vi);

	public int upComs(VideoInfo id);

	public int forbitComs(String[] ids);

	public int forbitDown(String[] ids);

	public int forbitTransmit(String[] ids);

	public List<VideoInfo> search(SearchKeyInfo ski);

	public VideoInfo getOne(String videoId);
	
	public int upStatus(String srcAddress);

	public int upDowns(VideoInfo video);

	public int upTransmit(VideoInfo video);
}
