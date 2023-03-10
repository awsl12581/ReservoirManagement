define('widgets/extension/statusUpdate', function () {
    var e = function (a) {
        var b = this;
        b.divid = a;
        b._init()
    };
    e.prototype = {
        _init: function () {
            _self = this;
            _self._setStatus()
        }, attrDefault: function (a, b, c) {
            if (typeof a.data(b) != 'undefined') {
                return a.data(b)
            }
            return c
        }, _setStatus: function () {
            _self = this;
            $(".xe-status-update").each(function (i, c) {
                var d = $(c), $nav = d.find('.xe-nav a'), $status_list = d.find('.xe-body li'),
                    index = $status_list.filter('.active').index(),
                    auto_switch = _self.attrDefault(d, 'auto-switch', 0), as_interval = 0;
                if (auto_switch > 0) {
                    as_interval = setInterval(function () {
                        goTo(1)
                    }, auto_switch * 1000);
                    d.hover(function () {
                        window.clearInterval(as_interval)
                    }, function () {
                        as_interval = setInterval(function () {
                            goTo(1)
                        }, auto_switch * 1000)
                    })
                }

                function goTo(a) {
                    index = (index + a) % $status_list.length;
                    if (index < 0) index = $status_list.length - 1;
                    var b = $status_list.filter('.active'), $to_show = $status_list.eq(index);
                    b.removeClass('active');
                    $to_show.addClass('active').fadeTo(0, 0).fadeTo(320, 1)
                }

                $nav.on('click', function (a) {
                    a.preventDefault();
                    var b = $(this).hasClass('xe-prev') ? -1 : 1;
                    goTo(b)
                })
            })
        }
    };
    return e
})