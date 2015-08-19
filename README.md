This is a demonstration of a bug in the circle.karma namespace in the circle-ci frontend repository. Put here as part of a bug report.

When working out how to use the karma runner very kindly supplied by circle-ci I ran across an interesting bug when it came to trying to get generative testing using double-check and clojurescript.test running.

This repository is as succicnt an example of this failing behaviour as I could manage.

Steps to reproduce:

1. install the node modules `npm install`
2. run `lein cljsbuild once`
3. run `karma start karma.test.conf.js --single-run`

It should error like so:

```
generate underplank$ karma start karma.test.conf.js --single-run
WARN [karma]: Port 9876 in use
INFO [karma]: Karma v0.12.37 server started at http://localhost:9877/
INFO [launcher]: Starting browser Chrome
INFO [launcher]: Starting browser Firefox
wINFO [Firefox 34.0.0 (Mac OS X 10.9.0)]: Connected on socket MTIVoEdOq-8tYv-ACNRO with id 17095806
INFO [Chrome 44.0.2403 (Mac OS X 10.9.5)]: Connected on socket xBDOLPUYu8bNYhAfCNRN with id 15100758
Chrome 44.0.2403 (Mac OS X 10.9.5) ERROR
  Uncaught Error: Doesn't support namespace:
  at <path hidden>/generate/resources/public/cljs/test/generate.js:2756
Firefox 34.0.0 (Mac OS X 10.9.0) ERROR
  Error: Doesn't support namespace:
  at <path hidden>/generate/resources/public/cljs/test/generate.js:2756
Firefox 34.0.0 (Mac OS X 10.9.0): Executed 1 of 3 ERROR (0.532 secs / 0.012 secs)
Chrome 44.0.2403 (Mac OS X 10.9.5): Executed 1 of 3 ERROR (0.253 secs / 0.002 secs)

```

If you change line 33 of circle.karma from

```
"suite" [(-> report :test-name namespace str)]
```

to

```
"suite" [(-> report :test-name str)]
```

then the test run is successful.
