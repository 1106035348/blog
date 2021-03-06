!function (e, t) {
    "object" == typeof exports && "undefined" != typeof module ? module.exports = t() : "function" == typeof define && define.amd ? define(t) : (e = e || self).showdownToc = t()
}(this, (function () {
    "use strict";

    function e(e, t, r) {
        return t in e ? Object.defineProperty(e, t, {
            value: r,
            enumerable: !0,
            configurable: !0,
            writable: !0
        }) : e[t] = r, e
    }

    function t(e, t) {
        var r = Object.keys(e);
        if (Object.getOwnPropertySymbols) {
            var n = Object.getOwnPropertySymbols(e);
            t && (n = n.filter((function (t) {
                return Object.getOwnPropertyDescriptor(e, t).enumerable
            }))), r.push.apply(r, n)
        }
        return r
    }

    return function () {
        var r = (arguments.length > 0 && void 0 !== arguments[0] ? arguments[0] : {}).toc;
        return function () {
            return [{
                type: "output", filter: function (n) {
                    var o = [];
                    n.replace(/(<h([1-6]).*?id="([^"]*?)".*?>(.+?)<\/h[1-6]>)|(<p>\[toc\]<\/p>)/g, (function (n, c, u, i, p) {
                        if ("<p>[toc]</p>" === n) o.push({type: "toc"}); else {
                            p = p.replace(/<[^>]+>/g, "");
                            var f = {anchor: i, level: Number(u), text: p};
                            r && r.push(f), o.push(function (r) {
                                for (var n = 1; arguments.length > n; n++) {
                                    var o = null != arguments[n] ? arguments[n] : {};
                                    n % 2 ? t(o, !0).forEach((function (t) {
                                        e(r, t, o[t])
                                    })) : Object.getOwnPropertyDescriptors ? Object.defineProperties(r, Object.getOwnPropertyDescriptors(o)) : t(o).forEach((function (e) {
                                        Object.defineProperty(r, e, Object.getOwnPropertyDescriptor(o, e))
                                    }))
                                }
                                return r
                            }({type: "header"}, f))
                        }
                        return ""
                    }));
                    var c = [];
                    return o.forEach((function (e, t) {
                        if ("toc" === e.type) if (o[t + 1] && "header" === o[t + 1].type) {
                            for (var r = [], n = o[t + 1].level, u = t + 1; o.length > u && "toc" !== o[u].type; u++) {
                                o[u].level === n && r.push(o[u])
                            }
                            c.push(r)
                        } else c.push([])
                    })), n = n.replace(/<p>\[toc\]<\/p>[\n]*/g, (function () {
                        var e = c.shift();
                        return e && e.length ? "<ol>".concat(e.map((function (e) {
                            var t = e.text;
                            return '<li><a href="#'.concat(e.anchor, '">').concat(t, "</a></li>")
                        })).join(""), "</ol>\n") : ""
                    }))
                }
            }]
        }
    }
}));