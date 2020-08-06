# SBT Problem Reproduction

For [SBT issue 5726](https://github.com/sbt/sbt/issues/5726).

## To reproduce

- Clone this repo and run:

```
cd plugin
sbt publishLocal
cd ../project-using-plugin
sbt
```

Then execute the `cucumber` task.  You will see:

```
[error] stack trace is suppressed; run 'last Test / cucumber' for the full output
[error] (Test / cucumber) java.util.NoSuchElementException
[error] Total time: 1 s, completed Aug 5, 2020 7:32:50 PM
```

Running `last Test / cucumber` will show:

```
[error] java.util.NoSuchElementException
[error]         at java.util.ArrayList$Itr.next(Unknown Source)
[error]         at java.util.Collections.max(Unknown Source)
[error]         at io.cucumber.core.feature.FeatureParser.parseResource(FeatureParser.java:43)
[error]         at java.util.function.BiFunction.lambda$andThen$0(Unknown Source)
[error]         at io.cucumber.core.resource.ResourceScanner.lambda$processResource$1(ResourceScanner.java:79)
[error]         at io.cucumber.core.resource.PathScanner$ResourceFileVisitor.visitFile(PathScanner.java:70)
[error]         at io.cucumber.core.resource.PathScanner$ResourceFileVisitor.visitFile(PathScanner.java:55)
[error]         at java.nio.file.Files.walkFileTree(Unknown Source)
[error]         at io.cucumber.core.resource.PathScanner.findResourcesForPath(PathScanner.java:48)
[error]         at io.cucumber.core.resource.PathScanner.findResourcesForUri(PathScanner.java:28)
[error]         at io.cucumber.core.resource.ResourceScanner.findResourcesForUri(ResourceScanner.java:61)
[error]         at io.cucumber.core.resource.ResourceScanner.scanForResourcesUri(ResourceScanner.java:134)
[error]         at io.cucumber.core.runtime.FeaturePathFeatureSupplier.loadFeatures(FeaturePathFeatureSupplier.java:62)
[error]         at io.cucumber.core.runtime.FeaturePathFeatureSupplier.get(FeaturePathFeatureSupplier.java:45)
[error]         at io.cucumber.core.runtime.Runtime.run(Runtime.java:78)
[error]         at myorg.cucumber_plugin.CucumberRunner$.run(CucumberRunner.scala:24)
[error]         at myorg.cucumber_plugin.CucumberSettings$.$anonfun$settings$3(CucumberSettings.scala:26)
[error]         at scala.runtime.java8.JFunction0$mcV$sp.apply(JFunction0$mcV$sp.java:23)
[error]         at sbt.std.Transform$$anon$3.$anonfun$apply$2(Transform.scala:46)
[error]         at sbt.std.Transform$$anon$4.work(Transform.scala:67)
[error]         at sbt.Execute.$anonfun$submit$2(Execute.scala:281)
[error]         at sbt.internal.util.ErrorHandling$.wideConvert(ErrorHandling.scala:19)
[error]         at sbt.Execute.work(Execute.scala:290)
[error]         at sbt.Execute.$anonfun$submit$1(Execute.scala:281)
[error]         at sbt.ConcurrentRestrictions$$anon$4.$anonfun$submitValid$1(ConcurrentRestrictions.scala:178)
[error]         at sbt.CompletionService$$anon$2.call(CompletionService.scala:37)
[error]         at java.util.concurrent.FutureTask.run(Unknown Source)
[error]         at java.util.concurrent.Executors$RunnableAdapter.call(Unknown Source)
[error]         at java.util.concurrent.FutureTask.run(Unknown Source)
[error]         at java.util.concurrent.ThreadPoolExecutor.runWorker(Unknown Source)
[error]         at java.util.concurrent.ThreadPoolExecutor$Worker.run(Unknown Source)
[error]         at java.lang.Thread.run(Unknown Source)
[error] (Test / cucumber) java.util.NoSuchElementException
```

`parseResource` is attempting to use `ServiceLoader` to load a cucumber gherkin class from cucumber-core, which I think should be reachable, since the plugin was able to load the io.cucumber.core classes in the stack trace.
