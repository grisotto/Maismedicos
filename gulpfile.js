var gulp = require('gulp');






// Copy vendor libraries from /templatefsw into /assets
gulp.task('copy', function() {

gulp.src([
    	'src/templatefsw/bootstrap/**/*'])
		.pipe(gulp.dest('src/main/resources/static/bootstrap'));

gulp.src([
	'src/templatefsw/dist/**/*'])
		.pipe(gulp.dest('src/main/resources/static/tema'));

gulp.src([
	'src/templatefsw/plugins/**/*'])
		.pipe(gulp.dest('src/main/resources/static/plugins'));
})

// Run everything
gulp.task('default', ['copy']);

// Configure the browserSync task
gulp.task('browserSync', function() {
    browserSync.init({
        server: {
            baseDir: ''
        },
    })
})


