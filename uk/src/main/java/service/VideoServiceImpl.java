package service;

import java.util.List;

import model.SearchKeyInfo;
import model.VideoInfo;

import org.springframework.beans.factory.annotation.Autowired;

import dao.VideoMapper;

public class VideoServiceImpl implements IVideoService {
	VideoMapper videoMapper;
	
	public VideoMapper getVideoMapper() {
		return videoMapper;
	}
	@Autowired
	public void setVideoMapper(VideoMapper videoMapper) {
		this.videoMapper = videoMapper;
	}
	
	@Override
	public VideoInfo getVideoById(String id) {
		// TODO Auto-generated method stub
		return videoMapper.getVideo(id);
	}

	@Override
	public List<VideoInfo> getAll(VideoInfo vi) {
		// TODO Auto-generated method stub
		return videoMapper.getAllVideo(vi);
	}

	@Override
	public int updateVideo(VideoInfo vi) {
		// TODO Auto-generated method stub
		return videoMapper.updateVideo(vi);
	}

	@Override
	public int delVideo(String[] id) {
		// TODO Auto-generated method stub
		return videoMapper.delVideo(id);
	}
	@Override
	public int addVideo(VideoInfo vi) {
		// TODO Auto-generated method stub
		return videoMapper.addVideo(vi);
	}
	@Override
	public int upComs(VideoInfo id) {
		// TODO Auto-generated method stub
		return videoMapper.upComs(id);
	}
	@Override
	public int forbitComs(String[] ids) {
		// TODO Auto-generated method stub
		return videoMapper.forbitComs(ids);
	}
	@Override
	public int forbitDown(String[] ids) {
		// TODO Auto-generated method stub
		return videoMapper.forbitDown(ids);
	}
	@Override
	public int forbitTransmit(String[] ids) {
		// TODO Auto-generated method stub
		return videoMapper.forbitTransmit(ids);
	}
	@Override
	public int count(VideoInfo vi) {
		// TODO Auto-generated method stub
		return videoMapper.count(vi);
	}
	@Override
	public List<VideoInfo> search(SearchKeyInfo ski) {
		// TODO Auto-generated method stub
		return videoMapper.search(ski);
	}
	@Override
	public VideoInfo getOne(String videoId) {
		// TODO Auto-generated method stub
		return videoMapper.getVideo(videoId);
	}
	@Override
	public int upStatus(String srcAddress) {
		// TODO Auto-generated method stub
		return videoMapper.upStatus(srcAddress);
	}
	@Override
	public int upDowns(VideoInfo video) {
		// TODO Auto-generated method stub
		return videoMapper.upDowns(video);
	}
	@Override
	public int upTransmit(VideoInfo video) {
		// TODO Auto-generated method stub
		return videoMapper.upTransmit(video);
	}

}
