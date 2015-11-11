/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 Shopify Inc.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.shopify.buy.ui.cart;

import android.content.Context;

import com.shopify.buy.dataprovider.BuyClient;
import com.shopify.buy.ui.common.BaseBuilder;
import com.shopify.buy.ui.common.BaseConfig;
import com.shopify.buy.ui.common.CheckoutListener;

public class CartBuilder extends BaseBuilder<CartBuilder> {

    public CartBuilder(Context context) {
        super(context);
    }

    public CartBuilder(Context context, BuyClient client) {
        super(context, client);
    }

    @Override
    protected BaseConfig getConfig() {
        if (config == null) {
            config = new BaseConfig();
        }
        return config;
    }

    /**
     * Returns a new {@link CartFragment} based on the params that have already been passed to the builder.
     *
     * @param listener An implementation of {@link CheckoutListener} which will be sent checkout status updates.
     * @return A new {@link CartFragment}.
     */
    public CartFragment buildFragment(CheckoutListener listener) {
        CartFragment fragment = new CartFragment();
        fragment.setCheckoutListener(listener);
        fragment.setArguments(buildBundle());
        return fragment;
    }

}