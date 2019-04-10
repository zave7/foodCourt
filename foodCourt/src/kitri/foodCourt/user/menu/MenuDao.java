package kitri.foodCourt.user.menu;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import kitri.foodCourt.user.menu.jdbc.ConnectionMaker;

public class MenuDao {

	private ConnectionMaker connectionMaker;
	public MenuDao(ConnectionMaker connectionMaker) {
		this.connectionMaker = connectionMaker;
	}
	
	//ī�װ��� �޴� Ŭ���� ���� �޴� ������
	public List<FoodDto> getMenubyCategory(int categori_id) {
		List<FoodDto> list = new ArrayList<FoodDto>();
		Connection c = null; 
		PreparedStatement ps = null; 
		ResultSet rs = null;
		try {
			c = connectionMaker.makeConnection();
			ps = c.prepareStatement("select food_name, image_address, food_id from fook_food where category_id = ?");
			ps.setInt(1, categori_id);
			rs = ps.executeQuery();
			//���� �̸�, �̹����ּ�, ���̵� (�޴� ����Ʈ�� �������� ������)
			while (rs.next()) {
				FoodDto food = new FoodDto();
				food.setFoodName(rs.getString("food_name"));
				food.setImageAddress(rs.getString("image_address"));
				food.setFoodId(rs.getString("food_id"));
				list.add(food);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(c != null) {
				try {
					c.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return list;
	}
	// �˻����� �޴� ������
	public List<FoodDto> getMenubyName(String foodName) {
		List<FoodDto> list = new ArrayList<FoodDto>();
		Connection c = null; 
		PreparedStatement ps = null; 
		ResultSet rs = null;
		try {
			c = connectionMaker.makeConnection();
			String str = "'%"+foodName+"%'";
			ps = c.prepareStatement("select food_name, image_address, food_id from fook_food where food_name like " + str);
//			ps.setString(1, foodName); //�ǹ��� ���� �߻� �ذ�!!!
			rs = ps.executeQuery();
			//���� �̸�, �̹����ּ�, ���̵� (�޴� ����Ʈ�� �������� ������)
			while (rs.next()) {
				FoodDto food = new FoodDto();
				food.setFoodName(rs.getString("food_name"));
				food.setImageAddress(rs.getString("image_address"));
				food.setFoodId(rs.getString("food_id"));
				list.add(food);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(c != null) {
				try {
					c.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return list;
	}
	
	public FoodDto getMenubyId(String food_id) {
		FoodDto foodDto = null;
		Connection c = null; 
		PreparedStatement ps = null; 
		ResultSet rs = null;
		try {
			c = connectionMaker.makeConnection();
			ps = c.prepareStatement("select food_name, image_address, food_id, description, price, c.category_id category_id from fook_food f, fook_category c where f.category_id = c.category_id and food_id = ?");
			ps.setString(1, food_id);
			rs = ps.executeQuery();
			if(rs.next()) {
				foodDto = new FoodDto();
				foodDto.setFoodName(rs.getString("food_name"));
				foodDto.setImageAddress(rs.getString("image_address"));
				foodDto.setFoodId(rs.getString("food_id"));
				foodDto.setPrice(rs.getInt("price"));
				foodDto.setCategoryName(rs.getString("category_id"));
				foodDto.setDescription(rs.getString("description"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(c != null) {
				try {
					c.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return foodDto;
	}
}