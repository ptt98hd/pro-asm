/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package manager;

/**
 *
 * @author thanh
 */
public interface IFunctions {

	void add();
	void update();
	void remove();
	void listAll();
	<T> T findById(String id);
	void save();
	void load();
}
