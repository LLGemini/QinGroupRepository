package sdkd.com.ec.service.impl;

import sdkd.com.ec.dao.impl.EbOrderDao;
import sdkd.com.ec.dao.impl.EbOrderDetailDao;
import sdkd.com.ec.dao.impl.EbProductDao;
import sdkd.com.ec.model.*;
import sdkd.com.ec.util.ConstantUtil;

import java.util.Date;

/**
 * Created by Flower on 2016/7/11.
 */
public class EbOrderService {
    EbOrderDao ebOrderDao = new EbOrderDao();
    EbOrderDetailDao ebOrderDetailDao = new EbOrderDetailDao();
    EbProductDao ebProductDao = new EbProductDao();

    /**
     * 支付订单
     * @param cart 购物车
     * @param user 用户
     */
    public void payOrder(EbShoppingCar cart, EbUser user) {
        EbOrder order = new EbOrder();
        order.setEo_user_id(user.getEu_user_id());
        order.setEo_user_name(user.getEu_user_name());
        order.setEo_user_address(user.getEu_address());

        order.setEo_cost(cart.getEsh_product_price());
        order.setEo_create_time(new Date());
        order.setEo_status(ConstantUtil.ORDER);
        order.setEo_type(ConstantUtil.ONLINEPAY);

        ebOrderDao.saveOrder(order);
        EbOrderDetail detail = new EbOrderDetail();
        EbProduct product = new EbProduct();


    }
}
