package kt.module.further_module.mvp

import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.alibaba.android.arouter.facade.annotation.Route
import kotlinx.android.synthetic.main.fragment_further.*
import kt.module.base_module.adapter.FurtherAdapter
import kt.module.base_module.base.view.BaseFragment
import kt.module.base_module.data.*
import kt.module.base_module.utils.RouteUtils
import kt.module.further_module.R

@Route(path = RouteUtils.RouterMap.FurtherPage.Further)
class FurtherFragment : BaseFragment<FurtherPresenter>(), FurtherContract.IFurtherView {

    override fun getODSuccessed(data: MutableList<ObjectEntity>?) {
        mDatas.clear()
        data?.forEach {
            var item = FurtherMultiItemEntity<MutableList<ChildEntity>>()
            if (it.show_template == 1) {
                item.type = 1
                item.title = "这个方向啊"
            } else {
                item.type = 0
                item.title = "那个方向啊"
            }
            item.data = it.child
            mDatas.add(item)
        }
        mAdapter?.setNewData(mDatas)
    }

    override fun getODFailed(msg: Any) {
        Toast.makeText(context, msg.toString(), Toast.LENGTH_SHORT).show()
    }

    override val contentLayoutId: Int
        get() = R.layout.fragment_further

    override val presenter: FurtherPresenter?
        get() = FurtherPresenter(this, FurtherModel())

    private var mAdapter: FurtherAdapter<MutableList<ChildEntity>>? = null

    var mDatas: MutableList<FurtherMultiItemEntity<MutableList<ChildEntity>>> = mutableListOf()

    override fun initViews() {
        fragment_details_recyclerView.layoutManager = LinearLayoutManager(context)

        mAdapter = FurtherAdapter()
        fragment_details_recyclerView.adapter = mAdapter
    }


    override fun initEvents() {
        presenter?.getPostTest(this)
    }
}