package android.wjf.android06.feicuiedu.com.housekeeper.adapter;

/**
 * Created by ad06-wjf on 2016/11/14.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 基础适配器, 根据集合内的数据，进行适配
 */
public abstract class BaseDataAdapter<E> extends BaseAdapter {

    private ArrayList<E> adapterDatas = new ArrayList<E>();

    protected Context context;

    protected LayoutInflater layoutInflater;// 布局加载器

    public BaseDataAdapter(Context context) {
        this.context = context;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return adapterDatas.size();
    }

    @Override
    public E getItem(int position) {
        // TODO Auto-generated method stub
        return adapterDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    public ArrayList<E> getDataFromAdapter() {
        return adapterDatas;
    }

    public void setDataToAdapter(List<E> e) {
        adapterDatas.clear();
        if (e != null) {

            adapterDatas.addAll(e);
        }
    }

    // 添加数据到当前适配器集合
    public void addDataToAdapter(E e) {
        if (e != null) {
            adapterDatas.add(e);
        }
    }

    // 添加数据到当前适配器集合
    public void addDataToAdapter(List<E> e) {
        if (e != null) {
            adapterDatas.addAll(e);
        }
    }

    public void clearAdapter() {
        adapterDatas.clear();
    }

    // 删除当前适配器集合内数据
    public void removeDataFromAdapter(E e) {
        adapterDatas.remove(e);
    }
    // 删除当前适配器集合内数据

    public void removeDataFromAdapter(int index) {
        adapterDatas.remove(index);
    }
}

