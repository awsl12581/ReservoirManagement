define('widgets/extension/numchange', function () {
    var d = function (a) {
        var b = this;
        b.divid = a;
        b._init()
    };
    d.prototype = {
        _init: function () {
            _self = this;
            _self._setDataScroll()
        }, attrDefault: function (a, b, c) {
            if (typeof a.data(b) != 'undefined') {
                return a.data(b)
            }
            return c
        }, _setDataScroll: function () {
            _self = this;
            $("#" + _self.divid + " [data-from][data-to]").each(function (i, b) {
                var c = $(b), sm = scrollMonitor.create(b);
                sm.fullyEnterViewport(function () {
                    var a = {
                            useEasing: _self.attrDefault(c, 'easing', true),
                            useGrouping: _self.attrDefault(c, 'grouping', true),
                            separator: _self.attrDefault(c, 'separator', ','),
                            decimal: _self.attrDefault(c, 'decimal', '.'),
                            prefix: _self.attrDefault(c, 'prefix', ''),
                            suffix: _self.attrDefault(c, 'suffix', ''),
                        }, $count = _self.attrDefault(c, 'count', 'this') == 'this' ? c : c.find(c.data('count')),
                        from = _self.attrDefault(c, 'from', 0), to = _self.attrDefault(c, 'to', 100),
                        duration = _self.attrDefault(c, 'duration', 2.5), delay = _self.attrDefault(c, 'delay', 0),
                        decimals = new String(to).match(/\.([0-9]+)/) ? new String(to).match(/\.([0-9]+)$/)[1].length : 0,
                        counter = new countUp($count.get(0), from, to, decimals, duration, a);
                    setTimeout(function () {
                        counter.start()
                    }, delay * 1000);
                    sm.destroy()
                })
            })
        }
    };
    return d
})