package com.inventory.repositories.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.inventory.repositories.vo.StockVo;

@Repository("StockDao")
public class StockDaoImpl implements StockDao {
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public List<StockVo> getStockInList(Map <String, String> params) {
		List <StockVo> list = sqlSession.selectList("stock.stockInList", params);
		return list;
	}

	@Override
	public List<StockVo> getStockInDetail(String inId) {
		List<StockVo>list = sqlSession.selectList("stock.stockInDetail", inId);
		return list;
	}

	@Override
	public boolean stockInCheck(Map <String, String> params) {
		int successUpdate = sqlSession.update("stock.confirmStockInCheckedIn", params);
		return successUpdate == 1;
	}

	@Override
	public boolean confirmStockIn(StockVo vo) {
		sqlSession.update("stock.confirmAndInventoryIn", vo);
		return true;
	}

	@Override
	public int getInId(String branchId) {
		return sqlSession.selectOne("stock.getStockInIdBybranchId", branchId);
	}

	@Override
	public int initialStockIn(String orderId, String branchId, String userName) {
		Map <String, String> map = new HashMap<>();
		map.put("orderId", orderId);
		map.put("branchId", branchId);
		map.put("userName", userName);
		return sqlSession.insert("stock.initialStockIn", map);
	}

	@Override
	public List<StockVo> getStockOutList(Map <String, String> params) {
		return sqlSession.selectList("stock.stockOutList", params);
	}
	
	@Override
	public List <StockVo> getStockOutDetail(String outId){
		return sqlSession.selectList("stock.stockOutDetail", outId);
	}

	@Override
	public int insertStockOut(String branchId, String userName) {
		Map <String, String> map = new HashMap<>();
		map.put("userName", userName);
		map.put("branchId", branchId);
		return sqlSession.insert("stock.confirmAndInsertStockOut", map);

	}

	@Override
	public int getStockOutId(String branchId) {
		return sqlSession.selectOne("stock.getStockOutIdByBranchId", branchId);
	}

	@Override
	public int insertOutDetail(StockVo vo) {
		return sqlSession.insert("stock.insertOutDetail", vo);
	}

	@Override
	public int confirmStockOut(StockVo vo) {
		return sqlSession.update("stock.confirmAndInventoryOut", vo);
	}

}
