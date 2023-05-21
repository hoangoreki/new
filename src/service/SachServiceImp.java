package service;

import java.util.List;

import Data.SachData;
import Data.SachDataImp;
import model.Sach;

public class SachServiceImp  implements SachService {
	private SachData sachData =null;
	public SachServiceImp() {
		sachData = new SachDataImp();
	}
	@Override
	public List<Sach> getList() {
		// TODO Auto-generated method stub
		return sachData.getList();
	}

}
