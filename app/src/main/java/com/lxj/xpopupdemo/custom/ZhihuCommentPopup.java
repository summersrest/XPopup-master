package com.lxj.xpopupdemo.custom;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.lxj.xpopup.widget.easyadapter.*;
import com.lxj.xpopup.XPopup;
import com.lxj.xpopup.core.BasePopupView;
import com.lxj.xpopup.core.BottomPopupView;
import com.lxj.xpopup.interfaces.SimpleCallback;
import com.lxj.xpopup.util.XPopupUtils;
import com.lxj.xpopup.widget.VerticalRecyclerView;
import com.lxj.xpopupdemo.DemoActivity;
import com.lxj.xpopupdemo.R;

import java.util.ArrayList;

/**
 * Description: 仿知乎底部评论弹窗
 * Create by dance, at 2018/12/25
 */
public class ZhihuCommentPopup extends BottomPopupView {
    VerticalRecyclerView recyclerView;
    private ArrayList<String> data;
    private EasyAdapter<String> commonAdapter;

    public ZhihuCommentPopup(@NonNull Context context) {
        super(context);
    }

    @Override
    protected int getImplLayoutId() {
        return R.layout.custom_bottom_popup;
    }

    @Override
    protected void onCreate() {
        super.onCreate();
        recyclerView = findViewById(R.id.recyclerView);
        findViewById(R.id.tv_temp).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //弹出新的弹窗用来输入
                final CustomEditTextBottomPopup textBottomPopup = new CustomEditTextBottomPopup(getContext());
                new XPopup.Builder(getContext())
                        .autoOpenSoftInput(true)
                        .autoFocusEditText(true)
                        .setPopupCallback(new SimpleCallback() {
                            @Override
                            public void onShow(BasePopupView popupView) {
                            }

                            @Override
                            public void onDismiss(BasePopupView popupView) {
                                String comment = textBottomPopup.getComment();
                                if (!comment.isEmpty()) {
                                    data.add(0, comment);
                                    commonAdapter.notifyDataSetChanged();
                                }
                            }
                        })
                        .asCustom(textBottomPopup)
                        .show();
            }
        });

        data = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            data.add("这是一个自定义Bottom类型的弹窗！你可以在里面添加任何滚动的View，我已经智能处理好嵌套滚动，你只需编写UI和逻辑即可！");
        }
        commonAdapter = new EasyAdapter<String>(data, R.layout.adapter_zhihu_comment) {
            @Override
            protected void bind(@NonNull ViewHolder holder, @NonNull String s, final int position) {
                holder.setText(R.id.name, "知乎大神 - " + position)
                        .setText(R.id.comment, s);
                holder.getView(R.id.btnDel).setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        data.remove(position);
                        commonAdapter.notifyItemRemoved(position);
                        commonAdapter.notifyItemRangeChanged(position, data.size());
                    }
                });
            }
        };
        commonAdapter.setOnItemClickListener(new MultiItemTypeAdapter.SimpleOnItemClickListener() {
            @Override
            public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {
                //不要直接这样做，会导致消失动画未执行完就跳转界面，不流畅。
//                dismiss();
//                getContext().startActivity(new Intent(getContext(), DemoActivity.class))
                //可以等消失动画执行完毕再开启新界面
//                dismissWith(new Runnable() {
//                    @Override
//                    public void run() {
//                        getContext().startActivity(new Intent(getContext(), DemoActivity.class));
//                    }
//                });
            }
        });
        recyclerView.setAdapter(commonAdapter);
    }

    //完全可见执行
    @Override
    protected void onShow() {
        super.onShow();
        Log.e("tag", "知乎评论 onShow");
    }

    //完全消失执行
    @Override
    protected void onDismiss() {
        Log.e("tag", "知乎评论 onDismiss");
    }

    @Override
    protected int getMaxHeight() {
        return (int) (XPopupUtils.getScreenHeight(getContext()) * .7f);
    }

    @Override
    protected boolean onBackPressed() {
        Toast.makeText(getContext(), "拦截返回", Toast.LENGTH_SHORT).show();
        return true;
    }
}