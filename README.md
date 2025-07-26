# DeepLink Redirect

Does your note-taking app support opening URLs but not DeepLinks?  

Do you want to link to a local file using a content URI (`content://package/path/file.ext`)?

This small, UI-less app intercepts all URLs starting with `example.com` or `example.org` and extracts everything after the first `/` as a DeepLink.

## How it works

+ If you open:
    ```
    https://example.org/content://package/path/file.ext
    ```

+ The app extracts the DeepLink:
    ```
    content://package/path/file.ext
    ```
+ Then, it launches the appropriate app to handle it

## Supported URL Formats
✅ http://example.org/content://package/path/file.ext  
✅ https://example.com/app://custom-scheme/path  
✅ https://example.com/any-deeplink-here
